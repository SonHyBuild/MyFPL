package com.example.myfpl.model;

public class Course {
   private int idKhoa;
   private String tenKhoa,doiTuong,thoiGian,moTa;

    public Course(int idKhoa, String tenKhoa, String doiTuong, String thoiGian, String moTa) {
        this.idKhoa = idKhoa;
        this.tenKhoa = tenKhoa;
        this.doiTuong = doiTuong;
        this.thoiGian = thoiGian;
        this.moTa = moTa;
    }

    public int getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(int idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

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
}
