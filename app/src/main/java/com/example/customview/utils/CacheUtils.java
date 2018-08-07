package com.example.customview.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheUtils {

    public static void putString(Context context,String key,String values){
        SharedPreferences sharedPreferences=context.getSharedPreferences("bioage",Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key,values).commit();
    }

    public static String getString(Context context,String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences("bioage",Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
