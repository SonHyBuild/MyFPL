package com.example.myfpl.services;

import com.example.myfpl.model.LoaiNha;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    // api get list
    //http://localhost/API_MYFPL/api/GetList.php
    String base_link="http://192.168.2.5/API_MYFPL/api/";
    @GET("GetList.php")
    Call<ArrayList<LoaiNha>> GetDS();
    @GET("Detail.php")
    Call<LoaiNha> GetDetails(@Query("id") int id);
}
