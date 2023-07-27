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
import com.example.myfpl.adapter.CoursesAdapter;
import com.example.myfpl.adapter.LichHocAdapter;


public class LichHocFragment extends Fragment {

    private RecyclerView recyclerViewLichHoc;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewLichHoc.setLayoutManager(linearLayoutManager);
        LichHocAdapter adapter= new LichHocAdapter(getContext());
        recyclerViewLichHoc.setAdapter(adapter);
    }
}