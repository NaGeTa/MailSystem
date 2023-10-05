package com.example.mailsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Test {

    private int id;

    private String title;

    private int countOfQuestions;

    private int countOfSolutions;

    private Date dateOfCreation = new Date(); //проверить при получении из БД меняется ли дата, сказать балычу

    private User creator;

    private Category category;
}
