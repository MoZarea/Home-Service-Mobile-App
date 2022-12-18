package com.example.homeservise.Domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Oders  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int orderID;
    int serviceID;
    int totalCost;
    String ser_title;
    String cat_title;
    String date;
    String time;
    String particular_address;
    String total_address;
    String notes;


    public Oders() {

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

    public String getParticular_address() {
        return particular_address;
    }

    public void setParticular_address(String particular_address) {
        this.particular_address = particular_address;
    }

    public String getTotal_address() {
        return total_address;
    }

    public void setTotal_address(String total_address) {
        this.total_address = total_address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
