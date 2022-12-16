package com.example.homeservise.Domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Oders {
    @PrimaryKey(autoGenerate = true)
    int orderID;
    int serviceID;
    int  totalCost;
    String ser_title;
    String cat_title;
    String date;
    String time;
    String address;

    public Oders(int serviceID, int totalCost, String ser_title, String cat_title, String date, String time, String address) {
        this.serviceID = serviceID;
        this.totalCost = totalCost;
        this.ser_title = ser_title;
        this.cat_title = cat_title;
        this.date = date;
        this.time = time;
        this.address = address;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getSer_title() {
        return ser_title;
    }

    public void setSer_title(String ser_title) {
        this.ser_title = ser_title;
    }

    public String getCat_title() {
        return cat_title;
    }

    public void setCat_title(String cat_title) {
        this.cat_title = cat_title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
