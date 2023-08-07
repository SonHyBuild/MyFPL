package com.example.myfpl.services;

import com.example.myfpl.model.Course;
import com.example.myfpl.model.InforCourse;
import com.example.myfpl.model.LichHoc;
import com.example.myfpl.model.LichThi;
import com.example.myfpl.model.TinTuc;
import com.example.myfpl.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {




    String base_link="http://192.168.2.5/API_MYFPL/api/";





//    lay ds lich hoc
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


    @GET("Detail.php")
    Call<TinTuc> GetDetailTT(@Query("idNews") int idNews);
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("AddForm.php")
    Call<InforCourse> addForm(@Field("email") String email,@Field("name") String name,
                              @Field("phoneNumber") String phoneNumber,
                              @Field("MSSV")String MSSV,@Field("subject")String subject);
}
