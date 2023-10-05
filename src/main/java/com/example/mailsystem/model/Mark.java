package com.example.mailsystem.model;

public enum Mark {
    A("ОТЛ"),
    B("ХОР"),
    C("УДОВ"),
    D("НЕУД");

    public final String value;

    Mark(String value){
        this.value=value;
    }
}
