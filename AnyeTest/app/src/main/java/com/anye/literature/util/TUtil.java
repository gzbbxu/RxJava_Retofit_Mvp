package com.anye.literature.util;

import android.util.Log;

import java.lang.reflect.ParameterizedType;

/**
 * Created by tchl on 2016-10-28.
 */
public class TUtil {
    public static <T> T getT(Object o, int i) {
        try {
            /*Log.d("TUtil","Class "+i+":type is "+  (Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i]);*/
            Log.e("zhouke","TUtil:"+o.getClass().getGenericSuperclass());
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
