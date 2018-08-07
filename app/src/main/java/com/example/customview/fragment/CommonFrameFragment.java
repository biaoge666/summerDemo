package com.example.customview.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.customview.R;
import com.example.customview.json.FastJsonActivity;
import com.example.customview.json.GsonActivity;
import com.example.customview.okhttp.OKHttpActivity;
import com.example.customview.adapter.CommonFrameFragmentAdapter;
import com.example.customview.base.BaseFragment;
import com.example.customview.json.NativeJsonParseActivity;
import com.example.customview.picasso.activity.PicassoActivity;

public class CommonFrameFragment extends BaseFragment {

    private ListView mListView;
    private String[] datas;

    @Override
    protected View initView() {
        View view =View.inflate(mContext, R.layout.fragment_common_frame,null);
        mListView=view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String data=datas[position];//okHttp
                if (data.toLowerCase().equals("okhttp")){
                    Intent intent=new Intent(mContext,OKHttpActivity.class);
                    mContext.startActivity(intent);
                }else if (data.toLowerCase().equals("nativeparsejson")){
                    Intent intent=new Intent(mContext, NativeJsonParseActivity.class);
                    mContext.startActivity(intent);
                }else if (data.toLowerCase().equals("gson")){
                    Intent intent=new Intent(mContext, GsonActivity.class);
                    mContext.startActivity(intent);
                }else if (data.toLowerCase().equals("fastjson")){
                    Intent intent=new Intent(mContext, FastJsonActivity.class);
                    mContext.startActivity(intent);
                }else if (data.toLowerCase().equals("picasso")){
                    Intent intent=new Intent(mContext, PicassoActivity.class);
                    mContext.startActivity(intent);
                }else if (data.toLowerCase().equals("glide")){
                    Intent intent=new Intent(mContext, PicassoActivity.class);
                    mContext.startActivity(intent);
                }
                Toast.makeText(mContext,"data="+data,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //设置适配器
        datas=new String[]{"okHttp","xUtils3","nativeParseJson","Gson","FastJson","picasso","Glide","Retrofit2","Fresco","greenDao","RxJava","volley","evenBus",
                "jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","......"};
        CommonFrameFragmentAdapter mCommonFrameFragmentAdapter = new CommonFrameFragmentAdapter(mContext, datas);
        mListView.setAdapter(mCommonFrameFragmentAdapter);
    }
}
