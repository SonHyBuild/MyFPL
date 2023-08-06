package com.example.myfpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;


import com.example.myfpl.activity.FormFragment;

import com.example.myfpl.activity.XuongFragment;

import com.example.myfpl.services.APIService;

import com.example.myfpl.activity.CoursesFragment;
import com.example.myfpl.activity.ThongBaoFragment;




import com.example.myfpl.activity.TabFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        replaceFragment(new TabFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new TabFragment());
                    break;
                case R.id.course:
                    replaceFragment(new FormFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new CoursesFragment());
                    break;
                case R.id.notification:
                    replaceFragment(new ThongBaoFragment());
                    break;
            }

            return true;
        });
        //anh xa
        //RecyclerView recyclerView = findViewById(R.id.recyclerView);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(APIService.base_link)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        APIService service = retrofit.create(APIService.class);
//        Call<ArrayList<LoaiNha>> response = service.GetDS();
//        response.enqueue(new Callback<ArrayList<LoaiNha>>() {
//            @Override
//            public void onResponse(Call<ArrayList<LoaiNha>> call, Response<ArrayList<LoaiNha>> response) {
//                ArrayList<LoaiNha> list = response.body();
//                Toast.makeText(MainActivity.this, "size: "+ list.size(), Toast.LENGTH_SHORT).show();
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//                recyclerView.setLayoutManager(linearLayoutManager);
//                LoaiNhaAdapter loaiNhaAdapter = new LoaiNhaAdapter(list,MainActivity.this);
//                recyclerView.setAdapter(loaiNhaAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<LoaiNha>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "FailAPI", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}

