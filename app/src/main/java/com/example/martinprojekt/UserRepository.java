package com.example.martinprojekt;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class UserRepository {

    public LiveData<List<User>> getUsers(){

        String USER_DEFAULT ="api/Valle-xd/result";

        final MutableLiveData<List<User>> data = new MutableLiveData<>();

        Call<UserResponse> call = APIClient.getAPIClient()
                .create(APIService.class)
                .getUsers(USER_DEFAULT);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                data.setValue(response.body().getUsers());


                Log.d("GET USER RESULTS", "onResponse: " + data.toString());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                Log.d("FAILURE LOOK HERE WHY", t.toString());
            }
        });
        return data;
    }
}
