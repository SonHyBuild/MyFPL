package com.example.myfpl.model;

public class Course {
    private String doiTuong,thoiGian,moTa;

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Course(String doiTuong, String thoiGian, String moTa) {
        this.doiTuong = doiTuong;
        this.thoiGian = thoiGian;
        this.moTa = moTa;
    }
}
