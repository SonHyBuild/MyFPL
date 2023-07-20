package com.example.myfpl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfpl.R;
import com.example.myfpl.model.LoaiNha;
import com.example.myfpl.services.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView txtID = findViewById(R.id.txtID);
        TextView txtTenLoai = findViewById(R.id.txtTenLoai);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<LoaiNha> response = service.GetDetails(Integer.parseInt(id));
        response.enqueue(new Callback<LoaiNha>() {
            @Override
            public void onResponse(Call<LoaiNha> call, Response<LoaiNha> response) {
                LoaiNha loaiNha = response.body();
                txtID.setText(loaiNha.getIdLoai());
                txtTenLoai.setText(loaiNha.getTenLoai());
            }

            @Override
            public void onFailure(Call<LoaiNha> call, Throwable t) {

            }
        });
    }
}