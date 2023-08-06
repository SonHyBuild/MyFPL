package com.example.myfpl.model;

public class InforCourse {
    private String email,name,phoneNumber,MSSV,subject;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public InforCourse(String email, String name, String phoneNumber, String MSSV, String subject) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.MSSV = MSSV;
        this.subject = subject;
    }
}
