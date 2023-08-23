package com.fahamin.assessmentapphpl.taskData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fahamin.assessmentapphpl.repository.Repository;

public class TaskViewModel extends AndroidViewModel {
    Repository repository;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);

    }

    LiveData<String> createTask(String name, String email, String contactNum) {
        return repository.createTask(name, email, contactNum);
    }


}
