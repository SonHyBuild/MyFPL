package com.example.myfpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;


import com.example.myfpl.activity.FormFragment;

import com.example.myfpl.activity.LichHocFragment;
import com.example.myfpl.activity.TabFragment2;
import com.example.myfpl.activity.XuongFragment;

import com.example.myfpl.services.APIService;

import com.example.myfpl.activity.CoursesFragment;
import com.example.myfpl.activity.HomeFragment;
import com.example.myfpl.activity.ThongBaoFragment;




import com.example.myfpl.activity.TabFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView,bottomNavigationView2;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.course:
                    replaceFragment(new TabFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new TabFragment2());
                    break;
                case R.id.notification:
                    replaceFragment(new ThongBaoFragment());
                    break;
            }

            return true;
        });


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}

