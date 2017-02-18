package com.explam.mvpdemo.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.explam.mvpdemo.R;
import com.explam.mvpdemo.adapter.MyAdapter;
import com.explam.mvpdemo.base.BaseMvpActivity;
import com.explam.mvpdemo.bean.BaiduBeautyBean;
import com.explam.mvpdemo.presenter.GirlPresenter;

/**
 * V层activity,通过接口回调,从presenter中转,得到model数据
 */
public class MainActivity extends BaseMvpActivity<GirlPresenter> implements IShowGirlView {
    private ListView mListview;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview = (ListView) findViewById(R.id.listview);
        Button button = (Button) findViewById(R.id.button);
        mListview.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击按钮后,让控制层去处理请求女孩图片的操作
                mPresenter.loadGirlData();
            }
        });
    }

    @Override
    protected GirlPresenter createPresenter() {
        return new GirlPresenter(this);
    }

    @Override
    public void getDataSuccess(BaiduBeautyBean data) {
        MyAdapter adapter = new MyAdapter(this, data.data);
        mListview.setAdapter(adapter);
    }

    @Override
    public void getDataFail(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("加载中");
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        mDialog.hide();
    }
}
