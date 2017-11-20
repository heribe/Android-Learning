package com.example.adminstration.uilayouttest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RelativeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
    }

    public static void actionStart(Context context, String data1){
        Intent intent = new Intent(context, RelativeLayout.class);
        intent.putExtra("param1", data1);
        context.startActivity(intent);
    }
}
