package com.example.customview.youku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.customview.R;

public class YoukuActivity extends AppCompatActivity {
    private RelativeLayout level1;
    private ImageView iconHome;
    private RelativeLayout level2;
    private ImageView iconSearch;
    private ImageView iconMenu;
    private ImageView iconMyyouku;
    private RelativeLayout level3;
    private boolean isShowLevel3 = true;
    private boolean isShowLevel2 = true;
    private boolean isShowLevel1 = true;
    private ImageView iconChannel1;
    private ImageView iconChannel2;
    private ImageView iconChannel3;
    private ImageView iconChannel4;
    private ImageView iconChannel7;
    private ImageView iconChannel6;
    private ImageView iconChannel5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        findViews();
        MyOnClickListener myOnClickListener = new MyOnClickListener();
        iconHome.setOnClickListener(myOnClickListener);
        iconMenu.setOnClickListener(myOnClickListener);


    }

    private void findViews() {
        level1 = findViewById(R.id.level1);
        iconHome = findViewById(R.id.icon_home);
        level2 = findViewById(R.id.level2);
        iconSearch = findViewById(R.id.icon_search);
        iconMenu = findViewById(R.id.icon_menu);
        level3 = findViewById(R.id.level3);
        iconMyyouku = findViewById(R.id.icon_myyouku);
        iconChannel1 = findViewById(R.id.icon_channel1);
        iconChannel2 = findViewById(R.id.icon_channel2);
        iconChannel3 = findViewById(R.id.icon_channel3);
        iconChannel4 = findViewById(R.id.icon_channel4);
        iconChannel7 = findViewById(R.id.icon_channel7);
        iconChannel6 = findViewById(R.id.icon_channel6);
        iconChannel5 = findViewById(R.id.icon_channel5);
    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.icon_home:
                    if (isShowLevel2) {
                        isShowLevel2 = false;
                        Tools.hideView(level2);
                        if (isShowLevel3) {
                            isShowLevel3 = false;
                            Tools.hideView(level3,200);
                        }
                    } else {
                        isShowLevel2 = true;
                        Tools.showView(level2);
                    }
                    break;
                case R.id.icon_menu:
                    if (isShowLevel3) {
                        isShowLevel3 = false;
                        Tools.hideView(level3);
                    } else {
                        isShowLevel3 = true;
                        Tools.showView(level3);
                    }
                    break;
            }
        }
    }
}

