package com.explam.mvpdemo.base;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 18:54
 * Desc: 基类的presenter类,进行view层引用的绑定和销毁,防止内存泄露
 */
public class BasePresenter<V> {
    public V mMvpView;

    /**
     * 绑定mvpview
     *
     * @param mvpView
     */
    public void attchView(V mvpView) {
        mMvpView = mvpView;
    }

    /**
     * 解绑mvpview,在activity销毁时调用,防止内存泄露
     */
    public void detachView() {
        mMvpView = null;
    }


}
