package com.example.adminstration.homework;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by adminstration on 2017/11/13.
 */

public class IDataAdapter extends ArrayAdapter<IData>{
    private int resourceId;
    public IDataAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<IData> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final IData iData = getItem(position);
        final View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView textView = view.findViewById(R.id.list_text);
        String itext = iData.getTitle()+"\n作者: "+iData.getAuthor()+"\n发布时间："+iData.getPublishDate();
        textView.setText(itext);
       //在主线程里更新图片
        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {

                ImageView imgView = (ImageView) view.findViewById(R.id.list_image);
                imgView. setImageBitmap((Bitmap) msg.obj);
            };
        };
        //在子线程里从网络获取图片
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                String urlpath = iData.getImageUrl();
                Bitmap bm = new GetNetImage().getInternetPicture(urlpath);
                Message msg = new Message();
                // 把bm存入消息中,发送到主线程
                msg.obj = bm;
                handler.sendMessage(msg);
            }
        }).start();
        return view;
    }
}
