package com.example.customview.glide.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.customview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitle.setText("Glide");
    }

    // 基本使用
    @OnClick(R.id.bt_glide_base)
    void bt_glide_base_click(View view){
        Intent intent = new Intent(GlideActivity.this, GlideBaseActivity.class);
        startActivity(intent);
    }

    // 在Recyclerview中使用
    @OnClick(R.id.bt_glide_recyclerview)
    void bt_glide_recyclerview_click(View view){
        Intent intent = new Intent(GlideActivity.this, GlideRecyclerviewActivity.class);
        startActivity(intent);
    }

    // 图片变换
    @OnClick(R.id.bt_glide_tranfromations)
    void bt_glide_tranfromations_click(View view){
        Intent intent = new Intent(GlideActivity.this, GlideTranformationsActivity.class);

        startActivity(intent);
    }
}
