package com.example.homeservise.Login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.homeservise.R;
import com.example.homeservise.databinding.ActivityOtpBinding;
import com.example.homeservise.databinding.Otpver1Binding;

public class Otpverify extends AppCompatActivity {
     Otpver1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        binding.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO..................

            }
        });
        binding.resendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO..................

            }
        });


    }


}