package com.example.ams.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class UserCredentials {
    private String full_name;
    private String login;
    private String password;

    public UserCredentials(String full_name, String login, String password) {
        this.full_name = full_name;
        this.login = login;
        this.password = password;
    }
}
