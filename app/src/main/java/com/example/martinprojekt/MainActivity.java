package com.example.martinprojekt;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity {

    private UserViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mViewModel.getUsers().observe(this, users -> {

            Log.d("her er dataen", "onActivityCreated: " + users.toString());

            ListView listView = findViewById(R.id.listView);
                String [] userData = new String[users.size()];
                for (int b = 0; b<users.size(); b++){
                    userData[b] = users.get(b).getName();

                }
                listView.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                userData)

                );

        });
    }
}
