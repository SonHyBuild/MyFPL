package com.example.myfpl.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myfpl.R;


public class DetailThongBaoFragment extends Fragment {

    public DetailThongBaoFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail_thong_bao,container,false);

        Bundle bundle = getArguments();
        String idNews=bundle.getString("idNews");
        Toast.makeText(getContext(), "aaa"+idNews, Toast.LENGTH_SHORT).show();
        return view;
    }
}