package com.fahamin.assessmentapphpl.repository;

import android.app.Application;
import android.util.Log;

import com.fahamin.assessmentapphpl.api.ApiService;
import com.fahamin.assessmentapphpl.api.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    ApiService apiService;

    public Repository(Application application) {
        apiService = ApiUtils.getAPIService();

    }

    public void registration(String name, String email, String contactNum) {
        apiService.registration(name, email, contactNum).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("fahamin", response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("fahamin", t.getMessage());

            }
        });
    }
}
