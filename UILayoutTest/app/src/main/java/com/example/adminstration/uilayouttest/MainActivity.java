package com.example.adminstration.uilayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.input_message);
        Button button1 = (Button) findViewById(R.id.send);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String inputs = editText.getText().toString();
                RelativeLayout.actionStart(MainActivity.this,inputs);
            }
        });

    }


}
