package com.example.myfpl.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfpl.R;
import com.example.myfpl.adapter.LichHocAdapter;
import com.example.myfpl.model.LichHoc;
import com.example.myfpl.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LichHocFragment extends Fragment {
    private  RecyclerView recyclerViewLichHoc ;
    public LichHocFragment() {
        // Required empty public constructor
    }

    public static LichHocFragment newInstance(String param1, String param2) {
        LichHocFragment fragment = new LichHocFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lich_hoc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewLichHoc = view.findViewById(R.id.recyclerViewLichHoc);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<LichHoc>> response = service.GetDSLH();
        response.enqueue(new Callback<ArrayList<LichHoc>>() {
            @Override
            public void onResponse(Call<ArrayList<LichHoc>> call, Response<ArrayList<LichHoc>> response) {
                ArrayList<LichHoc> list = response.body();

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerViewLichHoc.setLayoutManager(linearLayoutManager);
                LichHocAdapter adapter= new LichHocAdapter(getContext(), list);
                recyclerViewLichHoc.setAdapter(adapter);

                Toast.makeText(getContext(), "" + list.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<LichHoc>> call, Throwable t) {
                Toast.makeText(getContext(), "Không thành công", Toast.LENGTH_SHORT).show();
            }
        });


    }
}