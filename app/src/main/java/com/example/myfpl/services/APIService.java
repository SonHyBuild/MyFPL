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
    String base_link="http://172.16.78.35/API_MYFPL/api/";
    @GET("GetList.php")
    Call<ArrayList<LoaiNha>> GetDS();
    @GET("Detail.php")
    Call<LoaiNha> GetDetails(@Query("id") int id);

    //lay ds lich hoc
    @GET("LichHoc.php")
    Call<ArrayList<LichHoc>> GetDSLH();

    //lay ds lich thi
    @GET("LichThi.php")
    Call<ArrayList<LichThi>> GetDSLT();
    // get ds tin tức
    @GET("News.php")
    Call<ArrayList<TinTuc>> GetDSTT();




}
