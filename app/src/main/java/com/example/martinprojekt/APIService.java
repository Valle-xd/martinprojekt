package com.example.martinprojekt;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIService {

    @GET
    Call<UserResponse> getUsers
            (@Url String url);
}
