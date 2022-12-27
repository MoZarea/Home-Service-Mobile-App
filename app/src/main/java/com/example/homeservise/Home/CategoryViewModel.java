package com.example.homeservise.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.homeservise.Data.Category.Category;
import com.example.homeservise.Data.Repository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    /*--------------->reference on repo<---------------*/
    private Repository reposotiry;


    public CategoryViewModel(@NonNull Application application) {
        super(application);
        reposotiry=new Repository(application);

    }


    /*--------------->here all method needed to serve the UI <---------------*/
    void insert(Category category) {
        reposotiry.insert(category);
    }
    void update(Category category) {
        reposotiry.update(category);


    }

    void delete(Category category) {
        reposotiry.delete(category);


    }

    void deleteAllCategory() {
        reposotiry.deleteAllCategory();

    }

    LiveData<List<Category>> getAllCategory() {
        return reposotiry.getAllCategory();
    }

}
