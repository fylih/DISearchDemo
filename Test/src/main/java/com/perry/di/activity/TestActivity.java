package com.perry.di.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.perry.di.R;
import com.perry.di.adapter.RequestAdapter;
import com.perry.di.bean.ExpressionBean;
import com.perry.di.bean.StatisticsBean;
import com.perry.di.bean.TestBean;
import com.perry.http.Listener.AppCallback;
import com.perry.http.manager.RequestManager;
import com.perry.http.parser.HttpUrlEntry;
import com.perry.http.request.RzaSearchRequest;
import com.perry.http.request.RzaStatisticsRequest;
import com.perry.http.request.RzcSearchRequest;
import com.perry.http.request.RzcStatisticsRequest;
import com.perry.http.request.RzpSearchRequest;

/**
 * Created by lipengjun on 2016/11/29.
 */
public class TestActivity extends BaseActivity {

    Button buttonTest;
    //    ListView listview;
    RecyclerView recyclerView;
    RequestAdapter adapter;
    private String TAG = "TestActivity";
    RequestManager requestManager;

    String access_token = "89641c22-90be-430b-a14c-66602b9588b2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        requestManager = RequestManager.getInstance(TestActivity.this);
        buttonTest = (Button) findViewById(R.id.test_button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RequestAdapter(this);
        adapter.setOnRecyclerViewListener(new RequestAdapter.OnRecyclerViewListener() {
            @Override
            public void onItemClick(int position) {
                Log.e(TAG, "onItemClick:" + position);
            }

            @Override
            public void onItemClick(int position, HttpUrlEntry httpUrlEntry) {
                Log.e(TAG, "onItemClick:" + position + ",httpUrlEntry:" + httpUrlEntry.toString());
            }

            @Override
            public void onItemClick(int position, HttpUrlEntry httpUrlEntry, String keyStr,String categoryColumn) {
                Log.e(TAG, "onItemClick:" + position + ",httpUrlEntry:" + httpUrlEntry.toString()+",keyStr:"+keyStr+",categoryColumn:"+categoryColumn);
                //请求测试；
                textRequest(httpUrlEntry,keyStr,categoryColumn);
            }

            @Override
            public boolean onItemLongClick(int position) {
                Log.e(TAG, "onItemLongClick:" + position);
                return false;
            }
        });
        recyclerView.setAdapter(adapter);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 测试按钮

            }
        });
//
    }

    public void textRequest(final HttpUrlEntry httpUrlEntry, String keyStr,String categoryColumn) {

        if ("RzaSearchRequest".equals(httpUrlEntry.urlName)) {
            requestManager.sendRequest(new RzaSearchRequest("a815801fac1100086184a8699b9858d9", access_token, "read_cn", keyStr, "1", "", "").withResponse(ExpressionBean.class, new AppCallback<ExpressionBean>() {
                @Override
                public void callback(ExpressionBean bean) {
                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
                    intent.putExtra("bean",bean);
                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
                    intent.setClass(TestActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void callbackString(String str) {
//                    Toast.makeText(TestActivity.this,str,Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
//                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
//                    intent.setClass(TestActivity.this, MainActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(TestActivity.this, "错误提示:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }), httpUrlEntry.urlTitle);
        } else if ("RzaStatisticsRequest".equals(httpUrlEntry.urlName)) {
            // categoryColumn "TCS;TCSS;RY"
            if(categoryColumn == null || categoryColumn.length() == 0){
                categoryColumn = "TCS;TCSS;RY";
            }
            requestManager.sendRequest(new RzaStatisticsRequest("a815801fac1100086184a8699b9858d9", access_token, "read_cn", keyStr, categoryColumn).withResponse(StatisticsBean.class, new AppCallback<StatisticsBean>() {
                @Override
                public void callback(StatisticsBean statisticsBean) {
                    Intent intent = new Intent();
                    intent.putExtra("content", statisticsBean);
                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
                    intent.setClass(TestActivity.this, StatisticsActivity.class);
                    startActivity(intent);
                }

                @Override
                public void callbackString(String str) {
//                    Toast.makeText(TestActivity.this,str,Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
//                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
//                    intent.setClass(TestActivity.this, StatisticsActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(TestActivity.this, "错误提示:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }), httpUrlEntry.urlTitle);
        } else if ("RzcSearchRequest".equals(httpUrlEntry.urlName)) {
            requestManager.sendRequest(new RzcSearchRequest("a815801fac1100086184a8699b9858d9", access_token, "read_cn", keyStr, "1", "", "").withResponse(ExpressionBean.class, new AppCallback<ExpressionBean>() {
                @Override
                public void callback(ExpressionBean expressionBean) {
                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
                    intent.putExtra("bean",expressionBean);
                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
                    intent.setClass(TestActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void callbackString(String str) {
//                    Toast.makeText(TestActivity.this,str,Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
//                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
//                    intent.setClass(TestActivity.this, MainActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(TestActivity.this, "错误提示:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }), httpUrlEntry.urlTitle);
        } else if ("RzcStatisticsRequest".equals(httpUrlEntry.urlName)) {
            //categoryColumn  SWRN;TCS;RY
            if(categoryColumn == null || categoryColumn.length() == 0){
                categoryColumn = "SWRN;TCS;RY";
            }
            requestManager.sendRequest(new RzcStatisticsRequest("a815801fac1100086184a8699b9858d9", access_token, "read_cn",keyStr,categoryColumn).withResponse(StatisticsBean.class, new AppCallback<StatisticsBean>() {
                @Override
                public void callback(StatisticsBean statisticsBean) {
                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
                    intent.putExtra("content", statisticsBean);
                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
                    intent.setClass(TestActivity.this, StatisticsActivity.class);
                    startActivity(intent);
                }

                @Override
                public void callbackString(String str) {
//                    Toast.makeText(TestActivity.this,str,Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
//                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
//                    intent.setClass(TestActivity.this, StatisticsActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(TestActivity.this, "错误提示:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }), httpUrlEntry.urlTitle);
        } else if ("RzpSearchRequest".equals(httpUrlEntry.urlName)) {
            requestManager.sendRequest(new RzpSearchRequest("a815801fac1100086184a8699b9858d9", access_token, "read_cn", keyStr, "1", "", "").withResponse(ExpressionBean.class, new AppCallback<ExpressionBean>() {
                @Override
                public void callback(ExpressionBean expressionBean) {
                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
                    intent.putExtra("bean",expressionBean);
                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
                    intent.setClass(TestActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void callbackString(String str) {
//                    Toast.makeText(TestActivity.this,str,Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent();
//                    intent.putExtra("content", str);
//                    intent.putExtra("HttpUrlEntry", httpUrlEntry);
//                    intent.setClass(TestActivity.this, MainActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(TestActivity.this, "错误提示:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }), httpUrlEntry.urlTitle);
        }


    }
}
