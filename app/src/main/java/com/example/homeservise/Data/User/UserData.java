package com.example.homeservise.Data.User;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserData  {

 @PrimaryKey(autoGenerate = true)
    int  id ;
    String UID;
    String FSC;
    String name;
    String phone;
    String email;
    String address;

    public UserData(int id ,String name, String phone, String email,  String address) {
        this.id=id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
@Ignore
    public UserData() {
    }

    public String getFSC() {
        return FSC;
    }

    public void setFSC(String FSC) {
        this.FSC = FSC;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
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





    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
