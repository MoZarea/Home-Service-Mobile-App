package com.example.homeservise.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.homeservise.Data.Category.Category;
import com.example.homeservise.Data.Category.CategoryDao;
import com.example.homeservise.Listener.Order.OrderValueListener;
import com.example.homeservise.Listener.Service.ServicesOneValueListener;
import com.example.homeservise.Listener.Service.ServicesValueListener;
import com.example.homeservise.Listener.User.UserValueoneListener;
import com.example.homeservise.Data.Order.Orders;
import com.example.homeservise.Data.Order.OrdersDao;
import com.example.homeservise.Data.Service.Services;
import com.example.homeservise.Data.Service.ServicesDao;
import com.example.homeservise.Data.User.UserDao;
import com.example.homeservise.Data.User.UserData;

import java.util.List;

public class Repository {

    private ServicesDao servicesDao;
    private CategoryDao categoryDao;
    private UserDao userDao;
    private OrdersDao ordersDao;

    public Repository(Application application) {
        /*--------------->getting reference to database<---------------*/
        RoomDatabases database = RoomDatabases.getDatabase(application);
        /*--------------->getting reference to Dao's <---------------*/
        categoryDao = database.categoryDao();
        servicesDao = database.servicesDao();
        userDao = database.userDao();
        ordersDao = database.ordersDao();

    }
    ////////////////////////////////////////////////////
    /*--------------->category methods<---------------*/
    ////////////////////////////////////////////////////
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

    ////////////////////////////////////////////////////
    /*--------------->Service methods<---------------*/
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

    public void get_ser_by_id(int id, ServicesOneValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               Services services = servicesDao.get_ser_by_id(id);
                listener.onValueSubmit(services);
            }
        });
    }


    ////////////////////////////////////////////////////
    /*--------------->User data methods<---------------*/
    ////////////////////////////////////////////////////

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

    public void getUserByEmail(String email, UserValueoneListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                UserData userData = userDao.getUserByEmail(email);
                listener.getUserone(userData);
            }
        });
    }

    public void getUserByPhone(String phone, UserValueoneListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                UserData userData = userDao.getUserByPhone(phone);
                listener.getUserone(userData);
            }
        });

    }

    public LiveData<UserData> getUserByUID(String id) {

        return userDao.getUserByUID(id);

    }

    ////////////////////////////////////////////////////
    /*--------------->Order methods<---------------*/
    ////////////////////////////////////////////////////
    public void insert(Orders oders) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.insert(oders);

        });

    }

    public  void update(Orders oders) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.update(oders);

        });

    }

    public void delete(Orders oders) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.delete(oders);

        });

    }

    public void deleteAllOrders() {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            ordersDao.deleteAllOrders();

        });

    }

    public  LiveData<List<Orders>> getAllOders() {
        return ordersDao.getAllOders();
    }

    public  void  getOdersbyID(int id, OrderValueListener listener) {
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
