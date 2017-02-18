package com.explam.mvpdemo.model;

import com.explam.mvpdemo.bean.BaiduBeautyBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 19:44
 * Desc: 加载女孩数据model的实现类,版本1:从网络获取数据
 * 版本2:
 * 如果要从本地获取数据,只需重写一个类,实现ILoadGirlModel,就可以了,因为presenter持有的是ILoadGirlModel引用
 * 所以无需修改presenter里的任何东西,修改model的实现类就行了
 */
public class LoadGirlModelImplV1 implements ILoadGirlModel {
    String url = "http://image.baidu.com/channel/listjson?ie=utf8&rn=20&tag1=美女&tag2=网络美女&pn=0";

    @Override
    public void loadGirlData(final OnLoadGirlListener listener) {
        //网络请求美女图片数据,得到json,model层直接处理数据,返回实体bean(通过接口回调)
        OkGo.get(url).execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                BaiduBeautyBean baiduBeautyBean = new Gson().fromJson(s, BaiduBeautyBean.class);
                listener.onSuccess(baiduBeautyBean);
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                listener.onFail("请求数据失败,请检查网络连接!");
            }
        });
    }
}
