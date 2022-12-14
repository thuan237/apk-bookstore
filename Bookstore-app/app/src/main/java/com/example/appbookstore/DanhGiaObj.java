package com.example.appbookstore;

public class DanhGiaObj {
    private String avt, name, date, cmt;
    private float rating;

    public DanhGiaObj(String avt, String name, String date, String cmt, float rating) {
        this.avt = avt;
        this.name = name;
        this.date = date;
        this.cmt = cmt;
        this.rating = rating;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}