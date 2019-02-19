package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MultipleBean {

    private String id;

    @Override
    public String toString() {
        return "MultipleBean{" +
               "id='" + id + '\'' +
               ", surname='" + surname + '\'' +
               '}';
    }

    private String surname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
