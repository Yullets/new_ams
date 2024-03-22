package com.example.ams.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFullName {
    private String full_name;

    public UserFullName(String full_name) {
        this.full_name = full_name;
    }
}
