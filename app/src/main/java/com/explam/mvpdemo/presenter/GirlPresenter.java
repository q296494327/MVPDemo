package com.explam.mvpdemo.presenter;

import com.explam.mvpdemo.base.BasePresenter;
import com.explam.mvpdemo.base.IShowGirlView;
import com.explam.mvpdemo.bean.BaiduBeautyBean;
import com.explam.mvpdemo.model.ILoadGirlModel;
import com.explam.mvpdemo.model.LoadGirlModelImplV1;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 20:05
 * Desc: P层,控制层,持有V和M的引用,进行业务逻辑处理
 */
public class GirlPresenter extends BasePresenter<IShowGirlView> {
    ILoadGirlModel mGirlModel;

    public GirlPresenter(IShowGirlView view) {
        attchView(view);
        mGirlModel = new LoadGirlModelImplV1();
    }

    /**
     * 加载女孩数据,处理业务逻辑
     */
    public void loadGirlData() {
        mMvpView.showLoading();//展示进度框
        if (mGirlModel != null) {
            mGirlModel.loadGirlData(new ILoadGirlModel.OnLoadGirlListener() {
                @Override
                public void onSuccess(BaiduBeautyBean data) {
                    mMvpView.hideLoading();//隐藏进度框
                    mMvpView.getDataSuccess(data);
                }

                @Override
                public void onFail(String msg) {
                    mMvpView.getDataFail(msg);
                }
            });
        }
    }
}
