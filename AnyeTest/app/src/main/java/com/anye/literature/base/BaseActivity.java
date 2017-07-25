package com.anye.literature.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.anye.literature.baserx.RxManager;
import com.anye.literature.ui.presenter.LoadingPresenter;
import com.anye.literature.util.TUtil;

/**
 * Created by zkk_g on 2017/7/20.
 */

public abstract class BaseActivity<T extends LoadingPresenter,E extends  BaseModel> extends AppCompatActivity{
    public T mPresenter;
    public E mModel;
    public Context mContext;
    public RxManager mRxManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        setContentView(getLayoutId());
        mContext = this;
        mPresenter = TUtil.getT(this,0);
        mModel = TUtil.getT(this,1);
        if(mModel != null) {
        }
        if(mPresenter !=null){
            mPresenter.mContext = this;
        }
        initPresenter();
        initView();
        initData();
    }
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();
    //初始化view
    public abstract void initView();

    public abstract  void initData();

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
