package com.anye.literature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.literature.base.BaseActivity;
import com.anye.literature.bean.LoadingBean;
import com.anye.literature.ui.contract.LoadingContract;

public class LoadingActivity extends BaseActivity <LoadingContract.Presenter,LoadingContract.Model> implements LoadingContract.View{
    private TextView textview;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        textview = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void initData() {
        mPresenter.getLoadingDataRequest("2889289");
    }

    @Override
    public void showLoading(String title) {
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopLoading() {
        Toast.makeText(this,"停止对话框",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void returnLoadingInfo(LoadingBean loadingBeanInfo) {

    }

}
