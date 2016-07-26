package com.example.android.pelifull.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.pelifull.R;
import com.example.android.pelifull.fragment.MyPreferencesFragment;

public class MyPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_preferences);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.preferences_container,new MyPreferencesFragment())
                .commit();
    }
}
