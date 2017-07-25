package com.anye.literature.ui.presenter;

import com.anye.literature.baserx.RxSubscriber;
import com.anye.literature.bean.LoadingBean;
import com.anye.literature.ui.contract.LoadingContract;

import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by zhouke on 2017/7/25.
 */

public class LoadingPresenter extends LoadingContract.Presenter {
    @Override
    public void getLoadingDataRequest(String userid) {
  /*      mRxManager.add(mModel.getLoadingData("333").subscribe(new Subscriber<LoadingBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoadingBean loadingBean) {

            }
        }));*/
        mRxManager.add(mModel.getLoadingData("333").subscribe(new RxSubscriber<LoadingBean>(mContext,true) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading("请稍后...");
            }


            @Override
            protected void _onNext(LoadingBean loadingBean) {
                mView.returnLoadingInfo(loadingBean);
                mView.stopLoading();
            }

            @Override
            protected void _onError(String t) {
                mView.showErrorTip(t);
            }
        }));
    }
}
