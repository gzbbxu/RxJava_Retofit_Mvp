package com.anye.literature.api;

import com.anye.literature.basebean.BaseRespose;
import com.anye.literature.bean.LoadingBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhouke on 2017/7/25.
 */

public interface ApiService {
    @GET("function/init")
    Observable<BaseRespose<LoadingBean>> init(@Query("userid") String userid);
}
