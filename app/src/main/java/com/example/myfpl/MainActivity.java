package com.example.myfpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myfpl.adapter.LoaiNhaAdapter;
import com.example.myfpl.model.LoaiNha;
import com.example.myfpl.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<LoaiNha>> response = service.GetDS();
        response.enqueue(new Callback<ArrayList<LoaiNha>>() {
            @Override
            public void onResponse(Call<ArrayList<LoaiNha>> call, Response<ArrayList<LoaiNha>> response) {
                ArrayList<LoaiNha> list = response.body();
                Toast.makeText(MainActivity.this, "size: "+ list.size(), Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                LoaiNhaAdapter loaiNhaAdapter = new LoaiNhaAdapter(list,MainActivity.this);
                recyclerView.setAdapter(loaiNhaAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<LoaiNha>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "FailAPI", Toast.LENGTH_SHORT).show();
            }
        });
    }


}