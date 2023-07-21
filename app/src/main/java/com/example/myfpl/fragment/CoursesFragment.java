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

public class CoursesFragment extends Fragment {
    private RecyclerView recyclerView;
    public CoursesFragment() {
        // Required empty public constructor
    }


    public static CoursesFragment newInstance(String param1, String param2) {
        CoursesFragment fragment = new CoursesFragment();
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
        return inflater.inflate(R.layout.fragment_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView =view.findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CoursesAdapter  adapter= new CoursesAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }
}