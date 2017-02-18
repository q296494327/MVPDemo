package com.explam.mvpdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.explam.mvpdemo.R;
import com.explam.mvpdemo.bean.BaiduBeautyBean;

import java.util.List;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 23:21
 * Desc:
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<BaiduBeautyBean.BaiduBeautyData> datas;

    public MyAdapter(Context context, List<BaiduBeautyBean.BaiduBeautyData> datas) {
        mContext = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public BaiduBeautyBean.BaiduBeautyData getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaiduBeautyBean.BaiduBeautyData data = getItem(i);
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_pictures, null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        Glide.with(mContext).load(data.download_url).centerCrop().placeholder(R.mipmap
                .ic_launcher).crossFade().into(imageView);
        return view;
    }
}
