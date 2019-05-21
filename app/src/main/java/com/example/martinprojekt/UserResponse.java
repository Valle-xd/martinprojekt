package com.example.martinprojekt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    @SerializedName("result")
    private List<User> results;

    public List<User> getUsers(){
        return results;
    }
}
