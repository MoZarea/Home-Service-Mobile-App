package com.example.homeservise.Domain;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface ServicesValueListener {
    void onValueSubmit(List<Services> services);
}
