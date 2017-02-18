package com.explam.mvpdemo.model;

import com.explam.mvpdemo.bean.BaiduBeautyBean;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 19:31
 * Desc: M层基类接口,有获取数据的
 */
public interface ILoadGirlModel {
    /**
     * 加载女孩数据
     * @param listener 监听回调
     */
    void loadGirlData(OnLoadGirlListener listener);

    /**
     * 监听数据获取成功和失败的监听器
     */
    interface OnLoadGirlListener {
        void onSuccess(BaiduBeautyBean data);

        void onFail(String msg);
    }
}
