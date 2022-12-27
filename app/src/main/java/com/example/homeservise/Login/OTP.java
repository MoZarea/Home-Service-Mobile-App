package com.example.homeservise.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.homeservise.R;
import com.example.homeservise.databinding.ActivityOtpBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import org.jetbrains.annotations.NotNull;

public class OTP extends AppCompatActivity {
    ActivityOtpBinding binding;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        binding.sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =binding.inputEmail.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(OTP.this, "ادخل البريد الالكتروني ", Toast.LENGTH_SHORT).show();
                }
                else{
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(OTP.this, "تم ارسال لينك التفعيل للبريد الالكتروني ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getBaseContext(),Login.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(OTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }




            }
        });


    }


}






