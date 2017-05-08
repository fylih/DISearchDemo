package com.perry.di.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.perry.di.R;
import com.perry.di.adapter.StatisticsAdapter;
import com.perry.di.bean.StatisticsBean;
import com.perry.di.view.SwipeRefreshLayout;
import com.perry.http.parser.HttpUrlEntry;

public class StatisticsActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {

    TextView textView;
    TextView titleTV;
    TextView urlTV;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeLayout;
    StatisticsAdapter statisticsAdapter;
    StatisticsBean statisticsBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        textView = (TextView)findViewById(R.id.contentTextView);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipelayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        titleTV = (TextView)findViewById(R.id.item_tv_request_name);
        urlTV = (TextView)findViewById(R.id.item_tv_request_value);
        Intent intent = getIntent();
//        String content = intent.getStringExtra("content");
        statisticsBean = (StatisticsBean) intent.getSerializableExtra("content");
        HttpUrlEntry httpUrlEntry = (HttpUrlEntry) intent.getSerializableExtra("HttpUrlEntry");
        titleTV.setText(httpUrlEntry.urlTitle);
        urlTV.setText(httpUrlEntry.urlAddress);
        textView.setText(statisticsBean.toString());
        statisticsAdapter = new StatisticsAdapter(this);
        statisticsAdapter.setData(statisticsBean);
        initView();
    }

    private void initView(){
//        recyclerView.setLayoutManager(new WZMLinearLayoutManager());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(statisticsAdapter);

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
