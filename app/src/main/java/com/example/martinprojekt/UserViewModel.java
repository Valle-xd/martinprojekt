package com.example.martinprojekt;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private LiveData<List<User>> users;

    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository();
        users = userRepository.getUsers();
    }

    public LiveData<List<User>> getUsers() { return users; }
}
