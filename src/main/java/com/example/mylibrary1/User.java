package com.example.mylibrary1;

public class User {
    //10.прописуємо всі поля з БД
    private String firstnameusers;
    private String lastnameusers;
    private String loginusers;
    private String passwordusers;
    private String mailusers;
//11.cmd+n і  getter/setter та вибираємо всі поля
    //12.cmd+n construstor та вибираємо все

    public User(String firstnameusers, String lastnameusers, String loginusers, String passwordusers, String mailusers) {
        this.firstnameusers = firstnameusers;
        this.lastnameusers = lastnameusers;
        this.loginusers = loginusers;
        this.passwordusers = passwordusers;
        this.mailusers = mailusers;
    }

    public User() {
    }

    public String getFirstnameusers() {
        return firstnameusers;
    }

    public void setFirstnameusers(String firstnameusers) {
        this.firstnameusers = firstnameusers;
    }

    public String getLastnameusers() {
        return lastnameusers;
    }

    public void setLastnameusers(String lastnameusers) {
        this.lastnameusers = lastnameusers;
    }

    public String getLoginusers() {
        return loginusers;
    }

    public void setLoginusers(String loginusers) {
        this.loginusers = loginusers;
    }

    public String getPasswordusers() {
        return passwordusers;
    }

    public void setPasswordusers(String passwordusers) {
        this.passwordusers = passwordusers;
    }

    public String getMailusers() {
        return mailusers;
    }

    public void setMailusers(String mailusers) {
        this.mailusers = mailusers;
    }
}
