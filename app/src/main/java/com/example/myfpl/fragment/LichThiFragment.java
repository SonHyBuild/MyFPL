package com.example.myfpl.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfpl.R;
import com.example.myfpl.adapter.LichHocAdapter;
import com.example.myfpl.adapter.LichThiAdapter;


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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewLichThi.setLayoutManager(linearLayoutManager);
        LichThiAdapter adapter= new LichThiAdapter(getContext());
        recyclerViewLichThi.setAdapter(adapter);
    }
}