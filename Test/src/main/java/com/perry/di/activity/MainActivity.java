package com.perry.di.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.mrw.wzmrecyclerview.LayoutManager.WZMLinearLayoutManager;
import com.perry.di.R;
import com.perry.di.adapter.CopyrightAdapter;
import com.perry.di.bean.ExpressionBean;
import com.perry.di.view.SwipeRefreshLayout;
import com.perry.http.parser.HttpUrlEntry;

public class MainActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {

    TextView textView;
    TextView titleTV;
    TextView urlTV;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeLayout;
    private ExpressionBean expressionBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = (TextView)findViewById(R.id.contentTextView);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipelayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        titleTV = (TextView)findViewById(R.id.item_tv_request_name);
        urlTV = (TextView)findViewById(R.id.item_tv_request_value);
        Intent intent = getIntent();
//        String content = intent.getStringExtra("content");
        expressionBean = (ExpressionBean) intent.getSerializableExtra("bean");
        HttpUrlEntry httpUrlEntry = (HttpUrlEntry) intent.getSerializableExtra("HttpUrlEntry");
        titleTV.setText(httpUrlEntry.urlTitle);
        urlTV.setText(httpUrlEntry.urlAddress);
//        textView.setText(content);
        initView();
    }

    private void initView(){
        recyclerView.setLayoutManager(new WZMLinearLayoutManager());
        recyclerView.setAdapter(new CopyrightAdapter(this,expressionBean.context.records));

        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setOnLoadListener(this);
        mSwipeLayout.setColor(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeLayout.setMode(SwipeRefreshLayout.Mode.BOTH);
        mSwipeLayout.setLoadNoFull(true);

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoad() {

    }
}
