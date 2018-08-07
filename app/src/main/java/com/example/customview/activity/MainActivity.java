package com.example.customview.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.customview.R;
import com.example.customview.base.BaseFragment;
import com.example.customview.fragment.CommonFrameFragment;
import com.example.customview.fragment.CustomFragment;
import com.example.customview.fragment.OtherFragment;
import com.example.customview.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragment;

    private int position;
    /*
    * 上次切换的Fragment
    * */
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new MyOnCheckChangeListener());
        //设置默认选中页面
        radioGroup.check(R.id.rb_common_frame);
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFrameFragment());
        mBaseFragment.add(new CustomFragment());
        mBaseFragment.add(new OtherFragment());
        mBaseFragment.add(new ThirdPartyFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.rg_main);
//不能放这里
//        //设置默认选中页面
//        radioGroup.check(R.id.rb_common_frame);
    }

    class MyOnCheckChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_third_party:
                    position = 1;
                    break;
                case R.id.rb_custom:
                    position = 2;
                    break;
                case R.id.rb_other:
                    position = 3;
                    break;

                default:
                    position = 0;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment(mContent,to);
        }
    }

    private void switchFragment(Fragment from,Fragment to) {
        if (from != to){
            //切换
            mContent=to;
            FragmentTransaction fm=getSupportFragmentManager().beginTransaction();

            //判断有没有被添加
            if (!to.isAdded()){
                //没有被添加
                //from隐藏
                if (from != null){
                    fm.hide(from);
                }
                //添加to
                if (to !=null){
                    fm.add(R.id.fl_content,to).commit();
                }
            } else {
                //to已经被添加
                if (from !=null){
                    fm.hide(from);
                }

                if (to !=null){
                    fm.show(to).commit();
                }
            }
        }

    }

//    private void switchFragment(BaseFragment fragment) {
//        //1.得到fm
//        FragmentManager fm = getSupportFragmentManager();
//        //2.开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        //3.替换
//        /*
//        * replace()知识在上一个fragment不需要时调用,正确的是先add(),切换时hide(),show()另外一个
//        * */
//        transaction.replace(R.id.fl_content, fragment);
//        //4.提交事务
//        transaction.commit();
//    }

    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }
}
