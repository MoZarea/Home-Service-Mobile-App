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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class signupp extends AppCompatActivity {
    ActivitySignuppBinding binding;
    UserViewModel userViewModel;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    DatabaseReference myRef = database.getReference("UserData");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signupp);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();


            }
        });


        binding.btToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getBaseContext(), Login.class));

            }

        });


    }

    private void registerUser() {
        String email = binding.etEmailSign.getText().toString();
        String pass = binding.etPassword.getText().toString();
        String name = binding.etName.getText().toString();
        String phone = binding.etPhone.getText().toString();
        String conf_pass = binding.etConfPass.getText().toString();

        if (email.isEmpty() || pass.isEmpty() || name.isEmpty() || phone.isEmpty() || conf_pass.isEmpty()) {
            Toast.makeText(this, "اكمل باقي الحقول", Toast.LENGTH_SHORT).show();

        } else if (!pass.equals(conf_pass)) {
            Toast.makeText(this, "كلمه السر غير متطابقة ", Toast.LENGTH_SHORT).show();

        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = task.getResult().getUser();
                                Toast.makeText(signupp.this, "login done", Toast.LENGTH_SHORT).show();

                                // Create a new user with a first and last name


                                UserData newUser=new UserData();
                                newUser.setAddress("");
                                newUser.setPhone(phone);
                                newUser.setEmail(email);
                                newUser.setName(name);
                                newUser.setUID(FirebaseAuth.getInstance().getUid());

                                userViewModel.insert(newUser);
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
                                Toast.makeText(signupp.this, "login faild", Toast.LENGTH_SHORT).show();

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

