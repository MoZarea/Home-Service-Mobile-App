package com.example.homeservise.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.homeservise.Domain.Category;
import com.example.homeservise.Domain.Repository;
import com.example.homeservise.Domain.Services;

import java.util.List;

public class ServicesViewModel extends AndroidViewModel {
    private Repository reposotiry;
    //TODO  اعمل باقي القيم الراجعه
    private LiveData<List<Services>> allServices;
    private LiveData<List<Services>> AllCleanWorker;
    private LiveData<List<Services>> AllMechanicalWorker;
    private LiveData<List<Services>> AllPlumberWorker;
    private  LiveData<List<Services>> AllElictricalWorker;
    private LiveData<List<Services>> AllCarpenterWorker;
    private LiveData<List<Services>> AllWachingWorker;
    private LiveData<List<Services>> AllGardenWorker;

    public ServicesViewModel(@NonNull Application application) {
        super(application);
        reposotiry=new Repository(application);
        //TODO اعمل باقي القيم الراجعه
        allServices=reposotiry.getAllservices();
        AllCleanWorker=reposotiry.getAllCleanWorker();

        AllMechanicalWorker = reposotiry.getAllMechanicalWorker();
        AllPlumberWorker = reposotiry.getAllPlumberWorker();
        AllElictricalWorker = reposotiry.getAllElictricalWorker();
        AllCarpenterWorker = reposotiry.getAllCarpenterWorker();
        AllWachingWorker = reposotiry.getAllWachingWorker();
        AllGardenWorker = reposotiry.getAllGardenWorker();


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
        return allServices;
    }
    LiveData<List<Services>> getAllCleanWorker() {
        return AllCleanWorker;
    }

     LiveData<List<Services>> getAllMechanicalWorker() {
        return AllMechanicalWorker;
    }

     LiveData<List<Services>> getAllPlumberWorker() {
        return AllPlumberWorker;
    }

     LiveData<List<Services>> getAllElictricalWorker() {
        return AllElictricalWorker;
    }

     LiveData<List<Services>> getAllCarpenterWorker() {
        return AllCarpenterWorker;
    }

     LiveData<List<Services>> getAllWachingWorker() {
        return AllWachingWorker;
    }

     LiveData<List<Services>> getAllGardenWorker() {
        return AllGardenWorker;
    }

}
