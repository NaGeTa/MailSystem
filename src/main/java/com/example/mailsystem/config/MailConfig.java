package com.example.mailsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.getJavaMailProperties().setProperty("mail.debug", "true");

        mailSender.setHost("smtp.yandex.ru");
        mailSender.setPort(465);
        mailSender.setUsername("systemtes@yandex.ru");
        mailSender.setPassword("wqyippxdrvupateq");
        mailSender.setProtocol("smtps");

//        mailSender.setHost("smtp.mail.ru");
//        mailSender.setPort(465);
//        mailSender.setUsername("mailfortestingsystem@mail.ru");
//        mailSender.setPassword("DXSCRYUA3WMQRPy8jZ0y");
//        mailSender.setProtocol("smtps");
        return mailSender;
    }
}
