package com.anye.literature.base;

/**
 * Created by zhouke on 2017/7/25.
 */

public interface BaseView {
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
