package com.example.homeservise.Login;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.homeservise.Data.User.UserData;
import com.example.homeservise.Home.MainActivity;
import com.example.homeservise.Home.UserViewModel;
import com.example.homeservise.R;
import com.example.homeservise.databinding.ActivitySignuppBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
public class signupp extends AppCompatActivity {


    ActivitySignuppBinding binding;
    UserViewModel userViewModel;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*----------------------->inflate xml layout to java objects <--------------*/
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signupp);
        /*----------------------->bind view model with owner<--------------*/
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        /*----------------------->sign_up_btn OnClickListener<--------------*/
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        /*----------------------->login_btn OnClickListener<--------------*/
        binding.btToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Login.class));
            }
        });
    }

    /*--------->method to validate input data and create new user via firebase<--------------*/
    private void registerUser() {
        /*----------------------->get input data<-------------------------*/
        String email = binding.etEmailSign.getText().toString().trim();
        String pass = binding.etPassword.getText().toString().trim();
        String name = binding.etName.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();
        String conf_pass = binding.etConfPass.getText().toString().trim();
        /*--------------------------------------->validate data<-----------------------------------------*/
        if (email.isEmpty() || pass.isEmpty() || name.isEmpty() || phone.isEmpty() || conf_pass.isEmpty()) {
            Toast.makeText(this, "اكمل باقي الحقول", Toast.LENGTH_SHORT).show();


        } else if (!pass.equals(conf_pass)) {
            Toast.makeText(this, "كلمه السر غير متطابقة ", Toast.LENGTH_SHORT).show();

        } else if(pass.length()<6){
            Toast.makeText(this, "كلمة المرور يجب الا تقل عن 6 ارقام او حروف ", Toast.LENGTH_SHORT).show();

        }

        else {
            /*------------------->create new user via firebase Auth<-------------*/
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(signupp.this, "تم انشاء حساب جديد بنجاح", Toast.LENGTH_LONG).show();

                                UserData newUser=new UserData();
                                newUser.setAddress("");
                                newUser.setPhone(phone);
                                newUser.setEmail(email);
                                newUser.setName(name);
                                newUser.setUID(FirebaseAuth.getInstance().getUid());
                                /*---->save user data in local db <-------*/
                                userViewModel.insert(newUser);
                                /*------------------->save user data in remote db <------------------------*/
                                db.collection("new").document(FirebaseAuth.getInstance().getUid())
                                        .set(newUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                userViewModel.insert(newUser);
                                                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                                startActivity(intent);
                                            }
                                        })

                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error adding document", e);
                                            }
                                        });
                            } else {
                                Toast.makeText(signupp.this, "فشل انشاء حساب جديد يرجي المحاوله مره اخرى", Toast.LENGTH_LONG).show();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            System.out.println(e.getMessage());
                        }
                    });

        }


    }


}

