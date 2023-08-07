package com.example.myfpl.activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myfpl.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.model.User;
import com.example.myfpl.model.UserGG;
import com.example.myfpl.services.APIService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private  ImageButton imggg;
    private EditText edtEmail, edtPassword ;
    FirebaseAuth auth;
    FirebaseDatabase database;
    GoogleSignInClient mGoogleSignInClient;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        imggg=findViewById(R.id.imageButton);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Creating account");
        progressDialog.setMessage("We are Creating your account");

        GoogleSignInOptions gso= new GoogleSignInOptions.
                Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new  Intent(LoginActivity.this, MainActivity.class);
//                startActivity(i);
                goLogin();
            }
        });
        imggg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singIn();
            }
        });

    }

    int RC_SIGN_IN= 40;
    private void singIn() {
        Intent intent= mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }
    public void goLogin(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<Void> response = service.Login(email,password);

       response.enqueue(new Callback<Void>() {
           @Override
           public void onResponse(Call<Void> call, Response<Void> response) {
               if(response.isSuccessful()){
                   Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(intent);
                   finish();

               }else {
                   Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
               }

           }

           @Override
           public void onFailure(Call<Void> call, Throwable t) {
               Toast.makeText(LoginActivity.this, "Login API Fail", Toast.LENGTH_SHORT).show();
           }
       });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void firebaseAuth(String idToken) {
        AuthCredential credential= GoogleAuthProvider.getCredential(idToken,null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if ((task.isSuccessful()))
                        {
                            FirebaseUser user =auth.getCurrentUser();
                            UserGG userGG= new UserGG();
                            userGG.setUserId(user.getUid());
                            userGG.setName(user.getDisplayName());
                            userGG.setProfile(user.getPhotoUrl().toString());
                            database.getReference().child("Users").child(user.getUid()).setValue(userGG);
                            Log.d(TAG, "onCompleteaaaa: "+ userGG.getName());
                            Intent i = new  Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                        }else
                        {
                            Toast.makeText(LoginActivity.this, "erro", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}