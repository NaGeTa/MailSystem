package com.example.mailsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class User {

    private int id;

    private String first_name;

    private String last_name;

    private String login;

    private String email;

    private String password;

    private Date date_of_birth;

    private Date date_of_registration = new Date();

    private Role role;

    public boolean isBlocked(){
        return role == Role.BLOCKED;
    }
}
