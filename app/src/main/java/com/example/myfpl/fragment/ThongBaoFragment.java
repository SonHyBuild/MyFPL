package com.example.myfpl.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.adapter.ThongBaoAdapter;
import com.example.myfpl.model.TinTuc;
import com.example.myfpl.services.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThongBaoFragment extends Fragment {

    private ThongBaoAdapter mTBaoAdapter;
    private ArrayList<TinTuc> list;
    public ThongBaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        tt= new ArrayList<>();
//        tt.add(new TinTuc(3, "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "20-2-2023","a"));
//        tt.add(new TinTuc(4, "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "23-9-2023","a"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_thongbao,container,false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<TinTuc>> response=service.GetDSTT();
        response.enqueue(new Callback<ArrayList<TinTuc>>() {
            @Override
            public void onResponse(Call<ArrayList<TinTuc>> call, Response<ArrayList<TinTuc>> response) {
                list=response.body();
                Toast.makeText(getContext(), "  thành công"+list, Toast.LENGTH_SHORT).show();
                RecyclerView recyclerView=view.findViewById(R.id.thongbao);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                mTBaoAdapter=new ThongBaoAdapter(getContext(),list);
                recyclerView.setAdapter(mTBaoAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<TinTuc>> call, Throwable t) {
                Toast.makeText(getContext(), "không thành công", Toast.LENGTH_SHORT).show();
            }
        });
//


        return view;
    }
}
