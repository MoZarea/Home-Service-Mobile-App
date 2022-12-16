package com.example.homeservise.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.homeservise.Domain.Category;
import com.example.homeservise.Domain.Oders;
import com.example.homeservise.Domain.OfferValueListener;
import com.example.homeservise.Domain.OrderValueListener;
import com.example.homeservise.Domain.Repository;
import com.example.homeservise.Domain.RoomDatabases;
import com.example.homeservise.Domain.Services;
import com.example.homeservise.Domain.ServicesValueListener;

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

    LiveData<List<Services>> getAllServices() {
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

/////////////////////////////////////////////////////////////
///////////////////order////////////////////////////////
/////////////////////////////////////////////////////////////
    public void insert(Oders oders) {
            reposotiry.insert(oders);
    }

    public  void update(Oders oders) {
            reposotiry.update(oders);
    }

    public void delete(Oders oders) {
            reposotiry.delete(oders);
    }

    public void deleteAllOrders() {
            reposotiry.deleteAllOrders();
    }

    public  LiveData<List<Oders>> getAllOders() {
        return reposotiry.getAllOders();
    }

    public  void  getOdersbyID(int id, OrderValueListener listener) {
            reposotiry.getOdersbyID(id,listener);
    }

    public  void getUserByEmail(int serviceID,OrderValueListener listener) {
            reposotiry.getOdersbyID(serviceID,listener);
    }
}
