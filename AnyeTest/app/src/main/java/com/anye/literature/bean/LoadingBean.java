package com.anye.literature.bean;

/**
 * Created by Administrator on 2017/3/1 0001.
 */

public class LoadingBean {
    private String advertise;
    private String message;
    private String latest_version = "";
    private Coupons coupon;
    public Coupons getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupons coupon) {
        this.coupon = coupon;
    }





    public String getAdvertise() {
        return advertise;
    }

    public void setAdvertise(String advertise) {
        this.advertise = advertise;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLatest_version() {
        return latest_version;
    }

    public void setLatest_version(String latest_version) {
        this.latest_version = latest_version;
    }
}
