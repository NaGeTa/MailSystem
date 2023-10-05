package com.example.mailsystem.model;

public enum Role {
    STUDENT_ROLE("Студент"),
    TEACHER_ROLE("Преподаватель"),
    ADMIN_ROLE("Администратор"),
    BLOCKED("Заблокированный");

    public final String value;

    Role(String value){
        this.value=value;
    }
}
