package com.learn.models;

public class Email {

    String id;
    String emailName;

    public Email() {
    }

    public Email(String id, String emailName) {
        this.id = id;
        this.emailName = emailName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", emailName='" + emailName + '\'' +
                '}';
    }
}
