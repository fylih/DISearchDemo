package com.perry.di.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.perry.di.R;
import com.perry.di.bean.StatisticsBean;

import java.util.ArrayList;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.StatisticsHolder>{

    private Context context;
    private LayoutInflater mLayoutInflater;
    StatisticsBean data;
    ArrayList<StatisticsBean.VC> dataList;

    public StatisticsAdapter(Context context){
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        dataList = new ArrayList<>();
    }

    @Override
    public StatisticsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_statistics,parent,false);
        return new StatisticsHolder(view);
    }

    @Override
    public void onBindViewHolder(StatisticsHolder holder, int position) {
        StatisticsBean.VC vc = dataList.get(position);
        holder.value.setText(vc.value);
        holder.count.setText(vc.count);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(StatisticsBean data) {
        this.data = data;
        dataList.clear();
        if(data != null && data.context != null){
            if(data.context.ry != null) {
                dataList.addAll(data.context.ry);
            }
            if(data.context.swrn != null) {
                dataList.addAll(data.context.swrn);
            }
            if(data.context.tcs != null) {
                dataList.addAll(data.context.tcs);
            }
            if(data.context.tcss!= null) {
                dataList.addAll(data.context.tcss);
            }
        }
        notifyDataSetChanged();
    }

    public class StatisticsHolder extends ViewHolder{
        public TextView title;
        public TextView value;
        public TextView count;
        public LinearLayout linear;
        public StatisticsHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.tv_title);
            value = (TextView)itemView.findViewById(R.id.tv_value);
            count = (TextView)itemView.findViewById(R.id.tv_count);
            linear = (LinearLayout)itemView.findViewById(R.id.linear_content);
        }
    }
}