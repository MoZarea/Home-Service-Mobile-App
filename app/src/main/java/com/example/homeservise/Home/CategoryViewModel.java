package com.example.homeservise.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.homeservise.Domain.Category;
import com.example.homeservise.Domain.Repository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    //مؤشر على الREPO
    private Repository reposotiry;
    //TODO  اعمل باقي القيم الراجعه
    private LiveData<List<Category>> allCategory;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        reposotiry=new Repository(application);
        //TODO اعمل باقي القيم الراجعه
        allCategory=reposotiry.getAllCategory();
    }



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
        return allCategory;
    }

}
