package com.fahamin.assessmentapphpl.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.fahamin.assessmentapphpl.api.ApiService;
import com.fahamin.assessmentapphpl.api.ApiUtils;
import com.fahamin.assessmentapphpl.model.TaskModel;
import com.fahamin.assessmentapphpl.model.TaskModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    ApiService apiService;

    public Repository(Application application) {
        apiService = ApiUtils.getAPIService();

    }

    public MutableLiveData<String> registration(String name, String email, String contactNum) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

        apiService.registration(name, email, contactNum).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                } else {
                    mutableLiveData.setValue("error");

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("fahamin", t.getMessage());

            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<String> createTask(String ti, String dt, String num) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

        apiService.TaskEntry(ti, dt, num).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                } else {
                    mutableLiveData.setValue("error");

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }


    public MutableLiveData<List<TaskModelItem>> getTask(String num) {
        final MutableLiveData<List<TaskModelItem>> mutableLiveData = new MutableLiveData<>();

        apiService.TaskData(num).enqueue(new Callback<List<TaskModelItem>>() {
            @Override
            public void onResponse(Call<List<TaskModelItem>> call, Response<List<TaskModelItem>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                } else {
                    // mutableLiveData.setValue("error");

                }
            }

            @Override
            public void onFailure(Call<List<TaskModelItem>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

}
