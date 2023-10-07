package com.example.mailsystem.config;

import com.example.mailsystem.model.SolutionForMail;
import com.example.mailsystem.service.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@AllArgsConstructor
public class KafkaListenerConfig {

    private final ObjectMapper objectMapper;
    private final MailService mailService;

    @KafkaListener(topics = "mailTopic", containerFactory = "myListenerContainerFactory")
    public void listen(String data) {
        System.out.println(data + "\n");
        try {
            mailService.send(objectMapper.readValue(data, SolutionForMail.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
