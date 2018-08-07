package com.example.customview.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.customview.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpActivity extends Activity implements View.OnClickListener {

    private static final int GET = 1;
    private static final int POST = 2;
    private Button btn_get_post;
    private TextView tv_result;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case GET:
//                    tv_result.setText((String) msg.obj);
//                    break;
//                case POST:
//                    tv_result.setText((String) msg.obj);
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btn_get_post = findViewById(R.id.btn_get_post);
        tv_result = findViewById(R.id.tv_result);

        btn_get_post.setOnClickListener(this);
        tv_result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_post:
              getDataFromGet();
                break;
            case R.id.btn_post:
                getDataFromPost();
                break;
        }
    }

    private void getDataFromGet() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    final String  result = getUrl("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_result.setText(result);
                        }
                    });
//                    Message msg=Message.obtain();
//                    msg.what=GET;
//                    msg.obj=result;
//                    Log.e("TAG", result);
//                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private void getDataFromPost() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    final String  result = postUrl("http://api.m.mtime.cn/PageSubArea/TrailerList.api","");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_result.setText(result);
                        }
                    });
//                    Message msg=Message.obtain();
//                    msg.what=POST;
//                    msg.obj=result;
//                    Log.e("TAG", result);
//                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    //通过get方法,返回String
    //只能在子线程中
    private String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }




   private String postUrl(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
