package com.example.adminstration.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }


    private void initFruits(){
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.children);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.fish);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.children);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.fish);
            fruitList.add(watermelon);
            Fruit apple2 = new Fruit("Apple", R.drawable.children);
            fruitList.add(apple2);
            Fruit banana2 = new Fruit("Banana", R.drawable.fish);
            fruitList.add(banana2);
            Fruit orange2 = new Fruit("Orange", R.drawable.children);
            fruitList.add(orange2);
            Fruit watermelon2 = new Fruit("Watermelon", R.drawable.fish);
            fruitList.add(watermelon2);
        }
    }

}
