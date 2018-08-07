package com.example.customview.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.customview.base.BaseFragment;

public class ThirdPartyFragment extends BaseFragment {

    private TextView textView;
    @Override
    protected View initView() {
        textView=new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("第三方页面");
    }
}
