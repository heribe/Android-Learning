package com.example.adminstration.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secound_layout);
        Log.d(TAG, "Task id is"+ getTaskId());

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String data = "Hello ThirdActivity, I am MainActivty";
                /*Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("extra_data", data); //把数据暂时存到intent中
                startActivity(intent);*/
                ThirdActivity.actionStart(MainActivity.this, data);
            }
        });
    }
}
