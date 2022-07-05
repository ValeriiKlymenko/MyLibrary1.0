package com.example.mylibrary1;

public class Book {
    private String namebook;
    private String categorybook;
    private String datastartbook;
    private String datafinishbook;
    private String pagebook;
    private String notesbook;
    private String idstatus;
    private String idtype;
    private String idautor;

    public Book(String namebook, String categorybook, String datastartbook, String datafinishbook, String pagebook, String notesbook, String idstatus) {
        this.namebook = namebook;
        this.categorybook = categorybook;
        this.datastartbook = datastartbook;
        this.datafinishbook = datafinishbook;
        this.pagebook = pagebook;
        this.notesbook = notesbook;
        this.idstatus = idstatus;
        this.idtype = idtype;
        this.idautor = idautor;
    }

    public Book (){

    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getCategorybook() {
        return categorybook;
    }

    public void setCategorybook(String categorybook) {
        this.categorybook = categorybook;
    }

    public String getDatastartbook() {
        return datastartbook;
    }

    public void setDatastartbook(String datastartbook) {
        this.datastartbook = datastartbook;
    }

    public String getDatafinishbook() {
        return datafinishbook;
    }

    public void setDatafinishbook(String datafinishbook) {
        this.datafinishbook = datafinishbook;
    }

    public String getPagebook() {
        return pagebook;
    }

    public void setPagebook(String pagebook) {
        this.pagebook = pagebook;
    }

    public String getNotesbook() {
        return notesbook;
    }

    public void setNotesbook(String notesbook) {
        this.notesbook = notesbook;
    }

    public String getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(String idstatus) {
        this.idstatus = idstatus;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdautor() {
        return idautor;
    }

    public void setIdautor(String idautor) {
        this.idautor = idautor;
    }
}
