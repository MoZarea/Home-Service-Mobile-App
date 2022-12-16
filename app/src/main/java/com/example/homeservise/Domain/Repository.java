package com.example.homeservise.Domain;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class Repository {

    //TODO اعمل باقي الجداول هنا
    private ServicesDao servicesDao;
    private CategoryDao categoryDao;
    private UserDao userDao;
    private OrdersDao ordersDao;

    public Repository(Application application) {
        //عملت instance
        RoomDatabases database = RoomDatabases.getDatabase(application);
        //اكسس على الDAO
        //TODO اعمل باقي الجداول هنا
        categoryDao = database.categoryDao();
        servicesDao = database.servicesDao();
        userDao = database.userDao();
        ordersDao = database.ordersDao();

    }

    ///////////////////////////////////////////////////////////////////////
    ///////////////////////category//////////////////////////
    //////////////////////////////////////////////////////////////////
    public void insert(Category category) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.insert(category);

        });

    }

    public void update(Category category) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.update(category);

        });

    }

    public void delete(Category category) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.delete(category);

        });

    }

    public void deleteAllCategory() {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.deleteAllCategory();
        });

    }

    public LiveData<List<Category>> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    ////////////////////////////////////////////////////////
    ///////////////services//////////////////////
    ////////////////////////////////////////////////////
    public void insert(Services services) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.insert(services);

        });

    }

    public void update(Services services) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.update(services);

        });
    }

    public void delete(Services services) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.delete(services);

        });
    }

    public void deleteAllservices() {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.deleteAllservices();

        });
    }

    public LiveData<List<Services>> getAllservices() {
        return servicesDao.getAllservices();
    }

    public void getAllServicesByCat(String name, ServicesValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<Services> services = servicesDao.getAllServicesByCat(name);
                listener.onValueSubmit(services);
            }
        });
    }

    public LiveData<List<Services>> getAllOffer() {
        return servicesDao.getAllOffer();
    }

    public LiveData<List<Services>> getAllFavorute() {
        return servicesDao.getAllFavorute();
    }


    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////user Data//////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    public void insert(UserData userData) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insert(userData);
            }
        });
    }

    public void update(UserData userData) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.update(userData);
            }
        });
    }

    public void delete(UserData userData) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.delete(userData);
            }
        });
    }

    public void deleteAllUsers() {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.deleteAllUsers();
            }
        });
    }

    public LiveData<List<UserData>> getAllUsers() {
        return userDao.getAllUsers();
    }

    public LiveData<List<UserData>> getUserOne() {
        return userDao.getUserOne();
    }

    public void getUserByEmail(String email, UserValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<UserData> userData = userDao.getUserByEmail(email);
                listener.getUser(userData);
            }
        });
    }

    public void getUserByPhone(String phone, UserValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<UserData> userData = userDao.getUserByEmail(phone);
                listener.getUser(userData);
            }
        });

    }

    public void getUserByName(String name, UserValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<UserData> userData = userDao.getUserByEmail(name);
                listener.getUser(userData);
            }
        });
    }

    //////////////////////////////////////////////////////////////
    //////////////////order//////////////////////////////////
    //////////////////////////////////////////////////////////////
    public void insert(Oders oders) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.insert(oders);

        });

    }

    public  void update(Oders oders) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.update(oders);

        });

    }

    public void delete(Oders oders) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.delete(oders);

        });

    }

    public void deleteAllOrders() {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.deleteAllOrders();

        });

    }

    public  LiveData<List<Oders>> getAllOders() {
        return ordersDao.getAllOders();
    }

    public  void  getOdersbyID(int id,OrderValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            listener.getOrder(ordersDao.getOdersbyID(id));
        });
    }

    public  void getUserByEmail(int serviceID,OrderValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            listener.getOrder(ordersDao.getOdersbyID(serviceID));
        });
    }


}
