package com.example.myfpl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfpl.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.model.Course;
import com.example.myfpl.model.InforCourse;
import com.example.myfpl.services.APIService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormActivity extends AppCompatActivity {
    EditText email,name,phone,mssv,subject;
    Button btnRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        email = findViewById(R.id.edtEmailForm);
        name = findViewById(R.id.edtNameForm);
        phone = findViewById(R.id.edtPhoneForm);
        mssv = findViewById(R.id.edtMSSVForm);
        subject = findViewById(R.id.edtSubject);
        btnRegis =findViewById(R.id.btnRegisForm);

        Intent i = getIntent();
        String nameCourse = i.getStringExtra("nameCourse");
        subject.setText(nameCourse);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addForm();
            }
        });
    }
    public void addForm(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)

                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        Call<InforCourse> response = service.addForm(email.getText().toString(),name.getText().toString(),phone.getText().toString(),
                mssv.getText().toString(),subject.getText().toString());
        response.enqueue(new Callback<InforCourse>() {
            @Override
            public void onResponse(Call<InforCourse> call, Response<InforCourse> response) {
                Toast.makeText(FormActivity.this,"Đăng kí thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(FormActivity.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<InforCourse> call, Throwable t) {
                Toast.makeText(FormActivity.this, "Đăng kí thất bại: "+t, Toast.LENGTH_SHORT).show();
                Log.d(">>>>", "onFailure: "+t);
                Intent i = new Intent(FormActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}