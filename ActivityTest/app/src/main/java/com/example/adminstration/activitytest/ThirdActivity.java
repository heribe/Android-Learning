package com.example.adminstration.activitytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdActivity extends BaseActivity {
    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Log.d(TAG, "Task id is" + getTaskId());

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);//拨号盘
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.thirdgofirst);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.exit);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());//杀掉当前进程
            }
        });

        Intent intent = getIntent();
        String data = intent.getStringExtra("param1");//提取intent中的数据
        Log.d("ThirdActivity", data);

        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        Button button4 = (Button) findViewById(R.id.image_button);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.fish);
            }
        });
    }


    public static void actionStart(Context context, String data1){
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra("param1", data1);
        context.startActivity(intent);
    }

}
