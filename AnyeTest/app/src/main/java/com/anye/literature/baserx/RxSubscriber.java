package com.anye.literature.baserx;

import android.app.Activity;
import android.content.Context;

import com.anye.literature.baseapp.BaseApplication;
import com.anye.literature.commonutils.NetWorkUtils;
import com.anye.literature.widget.LoadingDialog;

import rx.Subscriber;

/**
 * Created by zhouke on 2017/7/25.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {
    private Context mContext;
    private String msg;
    private boolean showDialog = true;
    /*
    *是否显示浮动dialog
   * */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = false;
    }

    public RxSubscriber(Context context, String msg,boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog=showDialog;
    }
    public RxSubscriber(Context context,boolean showDialog) {
        this(context, "请稍后...",showDialog);
    }

    public RxSubscriber(Context context) {
        this(context, "请稍后...",true);
    }

    @Override
    public void onCompleted() {
        if (showDialog) {
            LoadingDialog.cancelDialogForLoading();
        }
    }

    @Override
    public void onError(Throwable e) {
        if(showDialog){
            LoadingDialog.cancelDialogForLoading();
        }
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError("网络访问错误，请稍后再试");
        }
        //服务器
        else if(e instanceof ServerException){
            _onError(e.getMessage());
        }
        else{
            _onError("网络访问错误，请稍后再试");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if(showDialog){
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String t);
}
