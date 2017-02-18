package com.explam.mvpdemo.base;

import com.explam.mvpdemo.bean.BaiduBeautyBean;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 19:18
 * Desc: V层界面展示数据的接口回调(由V层activity实现)
 */
public interface IShowGirlView extends BaseView {
    void getDataSuccess(BaiduBeautyBean data);

    void getDataFail(String msg);
}
