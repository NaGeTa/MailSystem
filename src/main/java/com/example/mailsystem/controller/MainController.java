package com.example.mailsystem.controller;

import com.example.mailsystem.model.ResetForMail;
import com.example.mailsystem.model.SolutionForMail;
import com.example.mailsystem.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final MailService mailService;

    @PostMapping("/sendSolution")
    public void sendSolution(@RequestBody SolutionForMail solution) {

        mailService.sendSolution(solution);

    }

    @PostMapping("/sendReset")
    public void sendReset(@RequestBody ResetForMail resetForMail) {

        mailService.sendReset(resetForMail);

    }


}
