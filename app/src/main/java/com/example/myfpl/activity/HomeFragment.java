package com.example.myfpl.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.myfpl.R;

public class HomeFragment extends Fragment {

    ViewFlipper v_flipper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v_flipper = view.findViewById(R.id.v_flipper);

        viewFlipper();

    }
    public void viewFlipper(){

        Animation animLeft = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left);
        Animation animRight = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right);

        v_flipper.setInAnimation(animLeft);
        v_flipper.setOutAnimation(animRight);
        v_flipper.setFlipInterval(1000);
        v_flipper.startFlipping();
    }

}