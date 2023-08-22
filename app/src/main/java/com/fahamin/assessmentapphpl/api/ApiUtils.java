package com.fahamin.assessmentapphpl.api;

import static com.fahamin.assessmentapphpl.utils.Constance.BASE_URL;


public class ApiUtils {

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }

}

