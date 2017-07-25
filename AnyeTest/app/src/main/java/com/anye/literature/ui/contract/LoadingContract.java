package com.anye.literature.ui.contract;

import com.anye.literature.base.BaseModel;
import com.anye.literature.base.BasePresenter;
import com.anye.literature.base.BaseView;
import com.anye.literature.bean.LoadingBean;

import rx.Observable;

/**
 * Created by zhouke on 2017/7/25.
 */

public interface LoadingContract {
    interface Model extends BaseModel{
        Observable<LoadingBean>getLoadingData(String userid);
    }
    interface View extends BaseView {
        void returnLoadingInfo(LoadingBean loadingBeanInfo);
    }

    public abstract static class Presenter extends BasePresenter<View,Model>{
       public abstract void getLoadingDataRequest(String userid);
    }


}
