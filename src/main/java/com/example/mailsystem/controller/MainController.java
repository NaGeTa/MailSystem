package com.example.mailsystem.controller;

import com.example.mailsystem.model.Solution;
import com.example.mailsystem.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final MailService mailService;

    @PostMapping("/")
    public void someMethod(@RequestBody Solution solution) {

        System.out.println(solution.getTest().getCreator().getEmail());

        mailService.send(solution);

    }


}
