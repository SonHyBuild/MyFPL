package com.example.myfpl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView,bottomNavigationView2;
    FloatingActionButton floatingActionButton;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        floatingActionButton = findViewById(R.id.floatingActionButton2);

        replaceFragment(new HomeFragment());
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator  intentIntegrator= new IntentIntegrator(MainActivity.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan a QR Code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult!=null){
            String contents = intentResult.getContents();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

