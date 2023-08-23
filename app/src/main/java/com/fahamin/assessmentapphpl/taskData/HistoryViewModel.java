package com.fahamin.assessmentapphpl.taskData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fahamin.assessmentapphpl.model.TaskModel;
import com.fahamin.assessmentapphpl.model.TaskModelItem;
import com.fahamin.assessmentapphpl.repository.Repository;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    Repository repository;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);

    }

    LiveData<List<TaskModelItem>> getTask(String contactNum) {
        return repository.getTask(contactNum);
    }

}
