package com.example.homeservise.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.homeservise.Domain.Repository;
import com.example.homeservise.Domain.UserData;
import com.example.homeservise.Domain.UserValueListener;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private Repository reposotiry;

    public UserViewModel(@NonNull Application application) {
        super(application);
        reposotiry=new Repository(application);

    }

    public void insert(UserData userData) {
                reposotiry.insert(userData);
    }

    public void update(UserData userData) {
                reposotiry.update(userData);
    }

    public void delete(UserData userData) {

                reposotiry.delete(userData);
    }

    public void deleteAllUsers() {

                reposotiry.deleteAllUsers();
    }

    public LiveData<List<UserData>> getAllUsers() {
        return reposotiry.getAllUsers();
    }

    public LiveData<List<UserData>> getUserOne() {
        return reposotiry.getUserOne();
    }

    public void getUserByEmail(String email, UserValueListener listener) {
               reposotiry.getUserByEmail(email,listener);
    }

    public void getUserByPhone(String phone, UserValueListener listener) {
                 reposotiry.getUserByEmail(phone,listener);
    }

    public void getUserByName(String name, UserValueListener listener) {
               reposotiry.getUserByEmail(name,listener);
    }
}
