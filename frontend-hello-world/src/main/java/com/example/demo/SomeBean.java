package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SomeBean {

    private String value;

    public String getDatePlanted() {
        return value;
    }

    public void setDatePlanted(String value) {
        this.value = value;
    }
}
