package com.anye.literature.base;

import android.content.Context;

import com.anye.literature.baserx.RxManager;

/**
 * Created by zkk_g on 2017/7/20.
 */

public abstract class BasePresenter<T,E> {
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManager;

    public void setVM(T v, E m) {
        mRxManager = new RxManager();
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {
    }

    ;

    public void onDestroy() {
        ;
    }
}
