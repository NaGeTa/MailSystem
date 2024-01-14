package com.example.mailsystem.config;

import com.example.mailsystem.model.ResetForMail;
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

    @KafkaListener(topics = "resultTopic", /*containerFactory = "myListenerContainerFactory",*/ groupId = "resultGroup")
    public void resultListen(String data) {
        System.out.println(data + "\n");
        try {
            mailService.sendSolution(objectMapper.readValue(data, SolutionForMail.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "resetTopic",/* containerFactory = "myListenerContainerFactory",*/ groupId = "resetGroup")
    public void resetListen(String data) {
        System.out.println(data + "\n");
        try {
            mailService.sendReset(objectMapper.readValue(data, ResetForMail.class));
            System.out.println("OKKKKKKK");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
