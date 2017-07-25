package com.anye.literature.basebean;

import java.io.Serializable;

/**
 * Created by zhouke on 2017/7/25.
 */

public class BaseRespose<T> implements Serializable {
    public String msg;
    public String code ;
    public T data;

    @Override
    public String toString() {
        return "BaseRespose{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
