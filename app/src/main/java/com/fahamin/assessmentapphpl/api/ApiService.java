package com.fahamin.assessmentapphpl.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Registration")
    Call<String> registration(
            @Field("name") String name,
            @Field("email") String email,
            @Field("contactNumber") String contactNumber
    );

    @FormUrlEncoded
    @POST("UnlinkRegistry")
    Call<String> UnlinkRegistry(
            @Field("contactNumber") String contactNumber
    );


    @FormUrlEncoded
    @POST("TaskEntry")
    Call<String> TaskEntry(
            @Field("title") String name,
            @Field("details") String email,
            @Field("contact_number") String contact_number
    );

    @FormUrlEncoded
    @POST("TaskData")
    Call<String> TaskData(
            @Field("contact_number") String contact_Number
    );
}
