package com.example.myfpl.services;

import com.example.myfpl.model.LichHoc;
import com.example.myfpl.model.LichThi;
import com.example.myfpl.model.LoaiNha;
import com.example.myfpl.model.TinTuc;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    // api get list
    //http://localhost/API_MYFPL/api/GetList.php

    //http://localhost/API_MYFPL/api/GetList.php
//    String base_link="http://192.168.101.47/apithuyen/api/";

    String base_link="http://192.168.1.10/API_MYFPL/api/";

    @GET("GetList.php")
    Call<ArrayList<LoaiNha>> GetDS();
    @GET("Detail.php")
    Call<LoaiNha> GetDetails(@Query("id") int id);

    @GET("GetTinTuc.php")
    Call<ArrayList<TinTuc>> GetDSTT();

    //lay ds lich hoc
    @GET("LichHoc.php")
    Call<ArrayList<LichHoc>> GetDSLH();

    //lay ds lich thi
    @GET("LichThi.php")
    Call<ArrayList<LichThi>> GetDSLT();

}
