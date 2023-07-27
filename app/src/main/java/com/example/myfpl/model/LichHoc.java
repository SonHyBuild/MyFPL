package com.example.myfpl.model;

public class LichHoc {
    public Integer idLH,idMH;
    public String nameMH, tearcherMH, caLH,locationLH,date_timeLH;

    public LichHoc(Integer idLH, Integer idMH, String nameMH, String tearcherMH, String caLH, String locationLH, String date_timeLH) {
        this.idLH = idLH;
        this.idMH = idMH;
        this.nameMH = nameMH;
        this.tearcherMH = tearcherMH;
        this.caLH = caLH;
        this.locationLH = locationLH;
        this.date_timeLH = date_timeLH;
    }

    public Integer getIdLH() {
        return idLH;
    }

    public void setIdLH(Integer idLH) {
        this.idLH = idLH;
    }

    public Integer getIdMH() {
        return idMH;
    }

    public void setIdMH(Integer idMH) {
        this.idMH = idMH;
    }

    public String getNameMH() {
        return nameMH;
    }

    public void setNameMH(String nameMH) {
        this.nameMH = nameMH;
    }

    public String getTearcherMH() {
        return tearcherMH;
    }

    public void setTearcherMH(String tearcherMH) {
        this.tearcherMH = tearcherMH;
    }

    public String getCaLH() {
        return caLH;
    }

    public void setCaLH(String caLH) {
        this.caLH = caLH;
    }

    public String getLocationLH() {
        return locationLH;
    }

    public void setLocationLH(String locationLH) {
        this.locationLH = locationLH;
    }

    public String getDate_timeLH() {
        return date_timeLH;
    }

    public void setDate_timeLH(String date_timeLH) {
        this.date_timeLH = date_timeLH;
    }
}
