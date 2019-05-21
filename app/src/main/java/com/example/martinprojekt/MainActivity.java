package com.example.martinprojekt;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;




public class MainActivity extends AppCompatActivity {

    private UserViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.listView);

        mViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mViewModel.getUsers().observe(this, users -> {

            Log.d("her er dataen", "onActivityCreated: " + users.toString());

            UserListAdapter adapter = new UserListAdapter(this, R.layout.adapter_view_layout, users);
            mListView.setAdapter(adapter);
        });
        Button mButton = findViewById(R.id.goBack);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
