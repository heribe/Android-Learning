package com.example.adminstration.homework;

import com.example.adminstration.homework.XListView;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener{
    private XListView listView;
    private List<IData> idatas;
    private List<IData> idatasPart = new ArrayList<>();
    private IDataAdapter adapter;
    private Handler mHandler;
    private int start = 0;
    private int refreshCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        ImageView bigImage = (ImageView) findViewById(R.id.bigimage);
        bigImage.setImageResource(R.drawable.pp);

        String foodJson = getJson(MainActivity.this, "get_data.json");
        Gson gson = new Gson();
        //将json内容赋入idatas中
        idatas = gson.fromJson(foodJson, new TypeToken<List<IData>>() {}.getType());
        //将第一页要显示的内容赋入idatasPart中
        geneItems();
        adapter = new IDataAdapter(MainActivity.this, R.layout.listview_layout, idatasPart);
        listView = (XListView) findViewById(R.id.xlist_view);
        listView.setPullLoadEnable(true);//上拉加载开
        listView.setPullRefreshEnable(true); //下拉刷新开
        listView.setAdapter(adapter);
        listView.setXListViewListener(this);//实现接口
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                IData idata = idatasPart.get(position);
                WebViewl.actionStart(MainActivity.this);
            } //点击列表后的反应
        });
        mHandler = new Handler();

    }

    //取出json文件内容并转化为String类型返回
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBUilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName),"utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBUilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBUilder.toString();
    }

    //给idatasPart里加内容
    private void geneItems() {
        for (int i = 0; i<4&&start<idatas.size(); ++i) {
            idatasPart.add(idatas.get(start++));
        }
    }

    //更新画面
    private void onLoad() {
        listView.stopRefresh();
        listView.stopLoadMore();
        listView.setRefreshTime("刚刚");
    }

    @Override
    //下拉刷新的动作
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                IData idataf = new IData();
                idataf.setTitle("我是新的新闻 "+(++refreshCnt));
                idataf.setImageUrl(idatas.get(0).getImageUrl());
                idatasPart.add(0, idataf);
                adapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }

    @Override
    //上拉加载的动作
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geneItems();
                adapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }
}
