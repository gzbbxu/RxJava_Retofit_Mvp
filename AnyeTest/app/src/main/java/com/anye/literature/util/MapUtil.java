package com.anye.literature.util;


import com.anye.literature.CommonApp;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zkk on 2017/1/18 0018.
 */

public class MapUtil {
    public  static Map<String,String> getSortMap(ParameterCallBack callBack, String url){
        Map<String,String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //必须要填的参数
        putKeyValue(map, "time", System.currentTimeMillis()+"","version", CommonApp.version,"device_id", CommonApp.szImei,"device_type","android");
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        sb.append("token=%s");//占位符号
        callBack.commonUrlParameter(sb.toString());

        return map;
    }
    public  static Map<String,String> getSortMapTime(ParameterCallBack callBack, String url, String time){
        Map<String,String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //必须要填的参数
        putKeyValue(map, "time",time+"","version", CommonApp.version,"device_id", CommonApp.szImei,"device_type","android");
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        sb.append("token=%s");//占位符号
        callBack.commonUrlParameter(sb.toString());

        return map;
    }
 /*   public  static Map<String,String> getSortMap(ParameterCallBack callBack, String url){
        Map<String,String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //必须要填的参数
        putKeyValue(map, "time","1484646309","version","0.0.1","device_id","iphone123","device_type","ios");
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        sb.append("token=%s");//占位符号
        callBack.commonUrlParameter(sb.toString());

        return map;
    }*/
    public static <K extends String,V extends String> String getValueKeyStringMd5(Map<K,V> map, String secret, String uri){
        StringBuilder sb = new StringBuilder(); //sb为所有的参数+secret+uri //secret默认 huiwenanye
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            sb.append(entry.getValue().toString()+entry.getKey().toString());
        }
        sb.append(secret);
        sb.append(uri);
        String md5 = MD5.md5(sb.toString());
        return md5;
    }
    public static <S> void putKeyValue(Map<S,S> map, S ...args){
        int length = args.length;

        for(int i=0;i<length;){
            map.put(args[i], args[i+1]);
            i+=2;
        }
    }
    public static <S> Map<S,S> removeBaseKey(Map<S,S> map){
        map.remove("time");
        map.remove("version");
        map.remove("device_id");
        map.remove("device_type");
        return  map;
    }
}
