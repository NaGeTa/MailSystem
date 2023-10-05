package com.example.mailsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Solution {

    private int id;

    private User user;

    private Test test;

    private Date dateOfSolution = new Date();

    private int countOfRightAnswers;

    private int countOfQuestions;

    private Mark mark;

    public void rating(){
        double percent = ((double)countOfRightAnswers)/((double)countOfQuestions);

        if(percent>=0.86){
            mark = Mark.A;
        } else if(percent>=0.66){
            mark = Mark.B;
        } else if(percent>=0.51) {
            mark = Mark.C;
        } else {
            mark = Mark.D;
        }

    }
}
