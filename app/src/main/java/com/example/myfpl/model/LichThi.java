package com.example.myfpl.model;

public class LichThi {
    public Integer idLT,idMH;
    public String caLT,locationLT,date_timeLT;

    public LichThi(Integer idLT, Integer idMH, String caLT, String locationLT, String date_timeLT) {
        this.idLT = idLT;
        this.idMH = idMH;
        this.caLT = caLT;
        this.locationLT = locationLT;
        this.date_timeLT = date_timeLT;
    }

    public Integer getIdLT() {
        return idLT;
    }

    public void setIdLT(Integer idLT) {
        this.idLT = idLT;
    }

    public Integer getIdMH() {
        return idMH;
    }

    public void setIdMH(Integer idMH) {
        this.idMH = idMH;
    }

    public String getCaLT() {
        return caLT;
    }

    public void setCaLT(String caLT) {
        this.caLT = caLT;
    }

    public String getLocationLT() {
        return locationLT;
    }

    public void setLocationLT(String locationLT) {
        this.locationLT = locationLT;
    }

    public String getDate_timeLT() {
        return date_timeLT;
    }

    public void setDate_timeLT(String date_timeLT) {
        this.date_timeLT = date_timeLT;
    }
}
