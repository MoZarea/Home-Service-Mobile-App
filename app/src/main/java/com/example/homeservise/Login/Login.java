package com.example.homeservise.Login;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.homeservise.Home.MainActivity;
import com.example.homeservise.R;
import com.example.homeservise.databinding.LoginScreenBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    LoginScreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflate layout xml
        binding = DataBindingUtil.setContentView(this, R.layout.login_screen);

        //listener of reset password
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO..................
            }
        });

        //listener of signUp
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getBaseContext(), signupp.class));

            }
        });

        //listener of login
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_user();
            }
        });
    }
    private void login_user() {
        String email = binding.phonee.getText().toString().trim();
        String pass = binding.pass.getText().toString().trim();
        /*--------------->make sure fields not empty<---------------*/
        if (!email.isEmpty() && !pass.isEmpty()) {
            /*--------------->login with email and password already exist<---------------*/
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = task.getResult().getUser();

                                Toast.makeText(Login.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login.this, "كلمة مرور او بريد الكتروني خاطئ", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
        else{
            Toast.makeText(this, " احد الحقول فارغة", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }


}