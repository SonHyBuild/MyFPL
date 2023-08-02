package com.example.myfpl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myfpl.R;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Intent i = getIntent();
        Integer id = i.getIntExtra("id",0);
        Toast.makeText(this, "id: "+id , Toast.LENGTH_SHORT).show();
    }
}