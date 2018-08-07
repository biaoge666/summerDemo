package com.example.customview.youku;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/*
* 显示和隐藏指定控件
* */

public class Tools {
    public static void hideView(View view) {
        /*
        * RotateAnimation ra=new RotateAnimation(0,180,view.getWidth()/2,view.getHeight());
        ra.setDuration(500);//设置动画播放持续的时间
        ra.setFillAfter(true);//动画停留在播放完成的状态
        view.startAnimation(ra);
        * 减小代码冗余
        * */
        hideView(view,0);

    }

    public static void showView(View view) {
        RotateAnimation ra=new RotateAnimation(180,360,view.getWidth()/2,view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);
        view.startAnimation(ra);

    }

    public static void hideView(View view, int i) {
        RotateAnimation ra=new RotateAnimation(0,180,view.getWidth()/2,view.getHeight());
        ra.setDuration(500);//设置动画播放持续的时间
        ra.setFillAfter(true);//动画停留在播放完成的状态
        ra.setStartOffset(i);//延迟多久后播放动画
        view.startAnimation(ra);
    }
}
