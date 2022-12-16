package com.example.homeservise.Domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserData {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String phone;
    String email;
    int  wallet;
    String address;

    public UserData(String name, String phone, String email, int wallet, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.wallet = wallet;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
