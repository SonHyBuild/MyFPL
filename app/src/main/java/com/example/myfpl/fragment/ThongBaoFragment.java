package com.example.myfpl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.adapter.ThongBaoAdapter;
import com.example.myfpl.model.TinTuc;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoFragment extends Fragment {
    private RecyclerView rvThongBao;
    private ThongBaoAdapter mTBaoAdapter;
    private List<TinTuc> tt;
    public ThongBaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tt= new ArrayList<>();
        tt.add(new TinTuc("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "20-2-2023","a"));
        tt.add(new TinTuc("60701", "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "23-9-2023","a"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_thongbao,container,false);
        rvThongBao = (RecyclerView)view.findViewById(R.id.thongbao);
        mTBaoAdapter = new ThongBaoAdapter(getContext(),  tt);
        rvThongBao.setAdapter(mTBaoAdapter);
        //RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvThongBao.setLayoutManager(linearLayoutManager);


        return view;
    }
}
