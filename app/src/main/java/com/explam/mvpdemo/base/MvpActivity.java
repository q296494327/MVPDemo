package com.explam.mvpdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 基类的V层,在创建和销毁时,与presenter绑定与解绑,防止内存泄露
 */
public abstract class MvpActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Override
    protected void onDestroy() {
        //在activity销毁时,解绑与presenter的关联防止内存泄露
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 创建presenter,子类必须实现
     *
     * @return
     */
    protected abstract P createPresenter();
}
