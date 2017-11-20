package com.example.adminstration.jsontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String json = "\"name\":\"tom\",\"id\":\"20\"";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gons = new Gson();
        App appList = gons.fromJson(json, App.class);
        Log.d("MainActivity", "id is"+ appList.getId());

    }
}
