package com.example.ams.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogPass {
    private String login;
    private String password;

    public LogPass(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
