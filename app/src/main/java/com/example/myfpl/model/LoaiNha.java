package com.example.myfpl.model;

public class LoaiNha {
    private String idLoai,tenLoai;

    public LoaiNha(String idLoai, String tenLoai) {
        this.idLoai = idLoai;
        this.tenLoai = tenLoai;
    }

    public String getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(String idLoai) {
        this.idLoai = idLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
