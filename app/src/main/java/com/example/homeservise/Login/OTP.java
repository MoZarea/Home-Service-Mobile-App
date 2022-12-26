package com.example.homeservise.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.homeservise.R;
import com.example.homeservise.databinding.ActivityOtpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTP extends AppCompatActivity {
    ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        binding.sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO..................

            }
        });


    }


}






