package com.example.homeservise.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.homeservise.Data.Order.Orders;
import com.example.homeservise.Listener.Order.OrderValueListener;
import com.example.homeservise.Data.Repository;
import com.example.homeservise.Data.Service.Services;
import com.example.homeservise.Listener.Service.ServicesOneValueListener;
import com.example.homeservise.Listener.Service.ServicesValueListener;

import java.util.List;

public class ServicesViewModel extends AndroidViewModel {
    private Repository reposotiry;

    public ServicesViewModel(@NonNull Application application) {
        super(application);
        reposotiry=new Repository(application);

    }
    void insert(Services services) {
        reposotiry.insert(services);
    }
    void update(Services services) {
        reposotiry.update(services);
    }

    void delete(Services services) {
        reposotiry.delete(services);
    }

    void deleteAllServices() {
        reposotiry.deleteAllservices();
    }

    public LiveData<List<Services>> getAllServices() {
        return reposotiry.getAllservices();
    }

    public void getAllServicesByCat(String name, ServicesValueListener listener) {
                reposotiry.getAllServicesByCat(name,listener);

    }

    public LiveData<List<Services>> getAllOffers() {
       return reposotiry.getAllOffer();
    }
    public LiveData<List<Services>> getAllFavorite() {
        return reposotiry.getAllFavorute();
    }


    public void get_ser_by_id(int id, ServicesOneValueListener listener) {
reposotiry.get_ser_by_id(id,listener);
    }

/////////////////////////////////////////////////////////////
///////////////////order////////////////////////////////
/////////////////////////////////////////////////////////////
    public void insert(Orders oders) {
            reposotiry.insert(oders);
    }

    public  void update(Orders oders) {
            reposotiry.update(oders);
    }

    public void delete(Orders oders) {
            reposotiry.delete(oders);
    }

    public void deleteAllOrders() {
            reposotiry.deleteAllOrders();
    }

    public  LiveData<List<Orders>> getAllOders() {
        return reposotiry.getAllOders();
    }

    public  void  getOdersbyID(int id, OrderValueListener listener) {
            reposotiry.getOdersbyID(id,listener);
    }
    public  void getUserByEmail(int serviceID,OrderValueListener listener) {
            reposotiry.getOdersbyID(serviceID,listener);
    }
}
