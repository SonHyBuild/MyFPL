package com.example.myfpl.services;

import com.example.myfpl.model.Course;
import com.example.myfpl.model.LichHoc;
import com.example.myfpl.model.LichThi;
import com.example.myfpl.model.TinTuc;
import com.example.myfpl.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    // api get list
    //http://localhost/API_MYFPL/api/GetList.php

    String base_link="http://192.168.1.10/API_MYFPL/api/";

    

    //lay ds lich hoc
    @GET("LichHoc.php")
    Call<ArrayList<LichHoc>> GetDSLH();

    //lay ds lich thi
    @GET("LichThi.php")
    Call<ArrayList<LichThi>> GetDSLT();
    // get ds tin tức
    @GET("News.php")
    Call<ArrayList<TinTuc>> GetDSTT();
    @GET("Course.php")
    Call<ArrayList<Course>> GetDSCourse();

    @GET("Login.php")
    Call<Void> Login(
            @Query("email") String email,
            @Query("password") String password
            );



}
