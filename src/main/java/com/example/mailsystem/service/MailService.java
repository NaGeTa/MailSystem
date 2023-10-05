package com.example.mailsystem.service;

import com.example.mailsystem.model.Solution;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    private final JavaMailSender sender;

    public void send(Solution solution){

        JavaMailSenderImpl senderImpl = (JavaMailSenderImpl)sender;
        Session session = senderImpl.getSession();
        session.setDebug(true);

        MimeMessageHelper message;
        try {
            message = new MimeMessageHelper(sender.createMimeMessage(), true);
            message.setFrom("systemtes@yandex.ru");
            message.setTo("dagestan200221@mail.ru");
            message.setSubject("Результаты выполения теста");
            message.setText("Решенный тест: " + solution.getTest().getTitle() + "\n"
                    + "Студент: " + solution.getUser().getFirst_name() + ' ' + solution.getUser().getLast_name() + "\n"
                    + "Оценка: " + solution.getMark().value);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        try {
            senderImpl.send(message.getMimeMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
