package com.anye.literature.baserx;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zkk_g on 2017/7/20.
 */

public class RxManager {
    public RxBus mRxBus = RxBus.getInstance();
    //管理rxbus订阅
    private Map<String, Observable<?>> mObservables = new HashMap<>();
    /*管理Observables 和 Subscribers订阅*/
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    /**
     * RxBus注入监听
     * @param eventName
     * @param action1
     */
    public <T>void on(String eventName, Action1<T> action1){
        Observable<T> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName,mObservable);
        /*订阅管理*/
        mCompositeSubscription.add(mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1,new Action1<Throwable>(){
                    @Override
                    public  void call(Throwable throwable){
                        throwable.printStackTrace();
                    }
                }));
    }

    /**
     * 单纯的Observables 和 Subscribers管理
     * @param m
     */
    public void add(Subscription m){
        /*订阅管理*/
        mCompositeSubscription.add(m);
    }

    /*
     *单个presenter生命周期结束，取消订阅和所有rxbus观察
    * */
    public void clear(){
        mCompositeSubscription.unsubscribe();//取消所有订阅
        for (Map.Entry<String, Observable<?>> entry:mObservables.entrySet()){
            mRxBus.unregister(entry.getKey(),entry.getValue());//移除rxbux观察
        }
    }
    //发送rxbus
    public void post(Object tag,Object content){ mRxBus.post(tag,content); }
}
