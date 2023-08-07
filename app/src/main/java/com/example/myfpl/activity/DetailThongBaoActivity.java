package com.example.myfpl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfpl.R;
import com.example.myfpl.model.TinTuc;
import com.example.myfpl.services.APIService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailThongBaoActivity extends AppCompatActivity {
    TextView title,content,date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_thong_bao);
        title=findViewById(R.id.title);
        date=findViewById(R.id.date2);
        content=findViewById(R.id.content2);
        Intent i = getIntent();
        int id= i.getIntExtra("id",0);
        Toast.makeText(this, "id: "+id, Toast.LENGTH_SHORT).show();
//        Bundle bundle = getIntent().getExtras();
//        int idNews= bundle.getInt("idNews");
//        Toast.makeText(this, "aaa"+idNews, Toast.LENGTH_SHORT).show();
//
//
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<TinTuc> response=service.GetDetailTT(id);
        response.enqueue(new Callback<TinTuc>() {
            @Override
            public void onResponse(Call<TinTuc> call, Response<TinTuc> response) {
                TinTuc tinTuc=response.body();
                title.setText(tinTuc.getTitle());
                content.setText(tinTuc.getContent());
                date.setText(tinTuc.getDate());

            }

            @Override
            public void onFailure(Call<TinTuc> call, Throwable t) {
                Toast.makeText(DetailThongBaoActivity.this, "khong thanh cong", Toast.LENGTH_SHORT).show();
                String errorMessage = t.getMessage();
                Toast.makeText(DetailThongBaoActivity.this, "Lỗi: " + errorMessage, Toast.LENGTH_SHORT).show();
                Log.d("aaaaaaaaaaaaaa",errorMessage);
            }
        });
    }
}
