package com.anye.literature.ui.model;

import com.anye.literature.bean.LoadingBean;
import com.anye.literature.ui.contract.LoadingContract;

import rx.Observable;

/**
 * Created by zhouke on 2017/7/25.
 */

public class NewsListModel implements LoadingContract.Model {
    @Override
    public Observable<LoadingBean> getLoadingData(String userid) {
        return null;
    }
}
