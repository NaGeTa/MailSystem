package com.example.mailsystem.service;

import com.example.mailsystem.model.ResetForMail;
import com.example.mailsystem.model.SolutionForMail;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class MailService {

    private final JavaMailSender sender;
    private final Environment environment;

    public void sendSolution(SolutionForMail solution) {

        JavaMailSenderImpl senderImpl = (JavaMailSenderImpl) sender;
        Session session = senderImpl.getSession();
        session.setDebug(true);

        MimeMessageHelper message;
        try {
            message = new MimeMessageHelper(sender.createMimeMessage(), true);
            message.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.username")));
            message.setTo(solution.getCreatorsMail());
            message.setSubject("Результаты выполения теста");
            message.setText("Решенный тест: %s\nСтудент: %s %s\nОценка: %s"
                    .formatted(solution.getTitle(), solution.getFirstName(), solution.getLastName(), solution.getMark()));
//            message.setText("Lol kek", "<html><body><a href=\"http://localhost:8080/tests\">Сюда</a></body></html>");

//            message.setTo("Hammotwerk@yandex.ru");
//            message.setSubject("Отсюда тоже могу");
//            message.setText("._.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        try {
            senderImpl.send(message.getMimeMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void sendReset(ResetForMail resetForMail) {

        JavaMailSenderImpl senderImpl = (JavaMailSenderImpl) sender;
        Session session = senderImpl.getSession();
        session.setDebug(true);

        MimeMessageHelper message;
        try {
            message = new MimeMessageHelper(sender.createMimeMessage(), true);
            message.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.username")));
            message.setTo(resetForMail.getMail());
            message.setSubject("Сброс пароля");
            message.setText("Сброс",
                    "<html><body><p>Password reset link: </p><a href=\"" + resetForMail.getURL() + "\">Click</a></body></html>");

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
