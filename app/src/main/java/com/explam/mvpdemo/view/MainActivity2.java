package com.explam.mvpdemo.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.explam.mvpdemo.R;
import com.explam.mvpdemo.adapter.MyAdapter;
import com.explam.mvpdemo.base.BaseMvpActivity;
import com.explam.mvpdemo.bean.BaiduBeautyBean;
import com.explam.mvpdemo.presenter.GirlPresenter;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 23:05
 * Desc: 如果要换一种V层显示,直接实现IShowGirlView接口就行了,P\M层不用做变动
 */
public class MainActivity2 extends BaseMvpActivity<GirlPresenter> implements IShowGirlView {
    private Button mButton;
    private GridView mGridview;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mGridview = (GridView) findViewById(R.id.gridview);
        mGridview.setVisibility(View.VISIBLE);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        MyAdapter adapter=new MyAdapter(this,data.data);
        mGridview.setAdapter(adapter);
    }

    @Override
    public void getDataFail(String msg) {
        Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("加载中");
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        mDialog.dismiss();
    }

}
