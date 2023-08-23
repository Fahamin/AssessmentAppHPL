package com.fahamin.assessmentapphpl.registration;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fahamin.assessmentapphpl.api.ApiService;
import com.fahamin.assessmentapphpl.api.ApiUtils;
import com.fahamin.assessmentapphpl.repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

public class RegistrationViewModel extends AndroidViewModel {
    Repository repository;

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    LiveData<String> registration(String name, String email, String contactNum) {
       return repository.registration(name, email, contactNum);
    }


}
