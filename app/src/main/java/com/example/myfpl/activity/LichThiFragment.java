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
import com.example.myfpl.adapter.LichThiAdapter;
import com.example.myfpl.model.LichThi;
import com.example.myfpl.services.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LichThiFragment extends Fragment {

    private RecyclerView recyclerViewLichThi;
    public LichThiFragment() {
        // Required empty public constructor
    }

    public static LichThiFragment newInstance(String param1, String param2) {
        LichThiFragment fragment = new LichThiFragment();
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
        return inflater.inflate(R.layout.fragment_lich_thi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewLichThi = view.findViewById(R.id.recyclerViewLichThi);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<LichThi>> response = service.GetDSLT();
        response.enqueue(new Callback<ArrayList<LichThi>>() {
            @Override
            public void onResponse(Call<ArrayList<LichThi>> call, Response<ArrayList<LichThi>> response) {
                ArrayList<LichThi> list = response.body();

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerViewLichThi.setLayoutManager(linearLayoutManager);
                LichThiAdapter adapter= new LichThiAdapter(getContext(), list);
                recyclerViewLichThi.setAdapter(adapter);

                Toast.makeText(getContext(), "" + list.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<LichThi>> call, Throwable t) {
                Toast.makeText(getContext(), "Không thành công", Toast.LENGTH_SHORT).show();
            }
        });


    }
}