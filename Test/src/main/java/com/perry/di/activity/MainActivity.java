package com.perry.di.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mrw.wzmrecyclerview.LayoutManager.WZMLinearLayoutManager;
import com.mrw.wzmrecyclerview.PullToRefresh.OnRefreshListener;
import com.mrw.wzmrecyclerview.PullToRefresh.PullToRefreshRecyclerView;
import com.perry.di.R;
import com.perry.di.adapter.CopyrightAdapter;
import com.perry.http.parser.HttpUrlEntry;

public class MainActivity extends BaseActivity {

    TextView textView;
    TextView titleTV;
    TextView urlTV;
    private PullToRefreshRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = (TextView)findViewById(R.id.contentTextView);
        LinearLayout layout = (LinearLayout) findViewById(R.id.title_include);
        recyclerView = (PullToRefreshRecyclerView) findViewById(R.id.recyclerView);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) recyclerView.getLayoutParams();
        params.topMargin = layout.getHeight();
        recyclerView.setLayoutParams(params);
        titleTV = (TextView)findViewById(R.id.item_tv_request_name);
        urlTV = (TextView)findViewById(R.id.item_tv_request_value);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        HttpUrlEntry httpUrlEntry = (HttpUrlEntry) intent.getSerializableExtra("HttpUrlEntry");
        titleTV.setText(httpUrlEntry.urlTitle);
        urlTV.setText(httpUrlEntry.urlAddress);
//        textView.setText(content);
        initView();
    }

    private void initView(){
        recyclerView.setLayoutManager(new WZMLinearLayoutManager());
        recyclerView.setAdapter(new CopyrightAdapter(this));
        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onStartRefreshing() {

            }
        });

    }
}
