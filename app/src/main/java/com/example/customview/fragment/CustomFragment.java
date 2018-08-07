package com.example.customview.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.customview.R;
import com.example.customview.base.BaseFragment;

public class CustomFragment extends BaseFragment implements View.OnClickListener {

    private Button java_call_h5;
    private Button h5_call_video;
    private Button h5_call_phone;

    public CustomFragment() {
    }

    @Override
    protected View initView() {
        View view =View.inflate(mContext, R.layout.fragment_custom,null);
        java_call_h5=view.findViewById(R.id.java_call_h5);
        h5_call_phone=view.findViewById(R.id.h5_call_phone);
        h5_call_video=view.findViewById(R.id.h5_call_video);
        java_call_h5.setOnClickListener(this);
        h5_call_video.setOnClickListener(this);
        h5_call_phone.setOnClickListener(this);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.java_call_h5:
                break;
            case R.id.h5_call_phone:
                break;
            case R.id.h5_call_video:
                break;
        }
    }
}
