package com.perry.di.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.perry.di.R;
import com.perry.di.bean.ExpressionBean;

import java.util.ArrayList;

public class CopyrightAdapter extends RecyclerView.Adapter{

    private Context context;
    private ArrayList<ExpressionBean.Record> list;
    private LayoutInflater mLayoutInflater;
    public CopyrightAdapter(Context context, ArrayList<ExpressionBean.Record> list){
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_copyright,parent,false);
        return new CopyRightHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CopyRightHolder copyRightHolder = (CopyRightHolder) holder;
        if (list == null || list.size()==0){
            return;
        }
        ExpressionBean.Record record = list.get(position);
        if (record==null){
            return;
        }

        if (TextUtils.isEmpty(record.tcss)){
            copyRightHolder.layout1.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout1.setVisibility(View.VISIBLE);
            copyRightHolder.textView_1.setText(record.tcss);
        }

        if (TextUtils.isEmpty(record.slid)){
            copyRightHolder.layout2.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout2.setVisibility(View.VISIBLE);
            copyRightHolder.textView_2.setText(record.slid);
        }

        if (TextUtils.isEmpty(record.swnm)){
            copyRightHolder.layout3.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout3.setVisibility(View.VISIBLE);
            copyRightHolder.textView_3.setText(record.swnm);
        }

        if (TextUtils.isEmpty(record.tcs)){
            copyRightHolder.layout4.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout4.setVisibility(View.VISIBLE);
            copyRightHolder.textView_4.setText(record.tcs);
        }

        if (TextUtils.isEmpty(record.swrn)){
            copyRightHolder.layout5.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout5.setVisibility(View.VISIBLE);
            copyRightHolder.textView_5.setText(record.swrn);
        }

        if (TextUtils.isEmpty(record.scid)){
            copyRightHolder.layout6.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout6.setVisibility(View.VISIBLE);
            copyRightHolder.textView_6.setText(record.scid);
        }

        if (TextUtils.isEmpty(record.fpy)){
            copyRightHolder.layout7.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout7.setVisibility(View.VISIBLE);
            copyRightHolder.textView_7.setText(record.fpy);
        }

        if (TextUtils.isEmpty(record.fy)){
            copyRightHolder.layout8.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout8.setVisibility(View.VISIBLE);
            copyRightHolder.textView_8.setText(record.fy);
        }

        if (TextUtils.isEmpty(record.type)){
            copyRightHolder.layout9.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout9.setVisibility(View.VISIBLE);
            copyRightHolder.textView_9.setText(record.type);
        }

        if (TextUtils.isEmpty(record.fd)){
            copyRightHolder.layout10.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout10.setVisibility(View.VISIBLE);
            copyRightHolder.textView_10.setText(record.fd);
        }

        if (TextUtils.isEmpty(record.pd)){
            copyRightHolder.layout11.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout11.setVisibility(View.VISIBLE);
            copyRightHolder.textView_11.setText(record.pd);
        }

        if (TextUtils.isEmpty(record.py)){
            copyRightHolder.layout12.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout12.setVisibility(View.VISIBLE);
            copyRightHolder.textView_12.setText(record.py);
        }

        if (TextUtils.isEmpty(record.fpd)){
            copyRightHolder.layout13.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout13.setVisibility(View.VISIBLE);
            copyRightHolder.textView_13.setText(record.fpd);
        }

        if (TextUtils.isEmpty(record.szid)){
            copyRightHolder.layout14.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout14.setVisibility(View.VISIBLE);
            copyRightHolder.textView_14.setText(record.szid);
        }

        if (TextUtils.isEmpty(record.owner)){
            copyRightHolder.layout15.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout15.setVisibility(View.VISIBLE);
            copyRightHolder.textView_15.setText(record.owner);
        }

        if (TextUtils.isEmpty(record.anm)){
            copyRightHolder.layout16.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout16.setVisibility(View.VISIBLE);
            copyRightHolder.textView_16.setText(record.anm);
        }

        if (TextUtils.isEmpty(record.rn)){
            copyRightHolder.layout17.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout17.setVisibility(View.VISIBLE);
            copyRightHolder.textView_17.setText(record.rn);
        }

        if (TextUtils.isEmpty(record.rd)){
            copyRightHolder.layout18.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout18.setVisibility(View.VISIBLE);
            copyRightHolder.textView_18.setText(record.rd);
        }

        if (TextUtils.isEmpty(record.ry)){
            copyRightHolder.layout19.setVisibility(View.GONE);
        }else {
            copyRightHolder.layout19.setVisibility(View.VISIBLE);
            copyRightHolder.textView_19.setText(record.ry);
        }





    }

    @Override
    public int getItemCount() {
        if (list==null || list.size()==0){
            return 0;
        }
        return list.size();
    }

    public class CopyRightHolder extends ViewHolder{
        private LinearLayout layout1;
        private LinearLayout layout2;
        private LinearLayout layout3;
        private LinearLayout layout4;
        private LinearLayout layout5;
        private LinearLayout layout6;
        private LinearLayout layout7;
        private LinearLayout layout8;
        private LinearLayout layout9;
        private LinearLayout layout10;
        private LinearLayout layout11;
        private LinearLayout layout12;
        private LinearLayout layout13;
        private LinearLayout layout14;
        private LinearLayout layout15;
        private LinearLayout layout16;
        private LinearLayout layout17;
        private LinearLayout layout18;
        private LinearLayout layout19;
        private TextView textView_1;
        private TextView textView_2;
        private TextView textView_3;
        private TextView textView_4;
        private TextView textView_5;
        private TextView textView_6;
        private TextView textView_7;
        private TextView textView_8;
        private TextView textView_9;
        private TextView textView_10;
        private TextView textView_11;
        private TextView textView_12;
        private TextView textView_13;
        private TextView textView_14;
        private TextView textView_15;
        private TextView textView_16;
        private TextView textView_17;
        private TextView textView_18;
        private TextView textView_19;

        public CopyRightHolder(View itemView) {
            super(itemView);
            layout1 = (LinearLayout) itemView.findViewById(R.id.layout1);
            layout2 = (LinearLayout) itemView.findViewById(R.id.layout2);
            layout3 = (LinearLayout) itemView.findViewById(R.id.layout3);
            layout4 = (LinearLayout) itemView.findViewById(R.id.layout4);
            layout5 = (LinearLayout) itemView.findViewById(R.id.layout5);
            layout6 = (LinearLayout) itemView.findViewById(R.id.layout6);
            layout7 = (LinearLayout) itemView.findViewById(R.id.layout7);
            layout8 = (LinearLayout) itemView.findViewById(R.id.layout8);
            layout9 = (LinearLayout) itemView.findViewById(R.id.layout9);
            layout10 = (LinearLayout) itemView.findViewById(R.id.layout10);
            layout11 = (LinearLayout) itemView.findViewById(R.id.layout11);
            layout12 = (LinearLayout) itemView.findViewById(R.id.layout12);
            layout13 = (LinearLayout) itemView.findViewById(R.id.layout13);
            layout14 = (LinearLayout) itemView.findViewById(R.id.layout14);
            layout15 = (LinearLayout) itemView.findViewById(R.id.layout15);
            layout16 = (LinearLayout) itemView.findViewById(R.id.layout16);
            layout17 = (LinearLayout) itemView.findViewById(R.id.layout17);
            layout18 = (LinearLayout) itemView.findViewById(R.id.layout18);
            layout19 = (LinearLayout) itemView.findViewById(R.id.layout19);
            textView_1 = (TextView) itemView.findViewById(R.id.text_1);
            textView_2 = (TextView) itemView.findViewById(R.id.text_2);
            textView_3 = (TextView) itemView.findViewById(R.id.text_3);
            textView_4 = (TextView) itemView.findViewById(R.id.text_4);
            textView_5 = (TextView) itemView.findViewById(R.id.text_5);
            textView_6 = (TextView) itemView.findViewById(R.id.text_6);
            textView_7 = (TextView) itemView.findViewById(R.id.text_7);
            textView_8 = (TextView) itemView.findViewById(R.id.text_8);
            textView_9 = (TextView) itemView.findViewById(R.id.text_9);
            textView_10 = (TextView) itemView.findViewById(R.id.text_10);
            textView_11 = (TextView) itemView.findViewById(R.id.text_11);
            textView_12 = (TextView) itemView.findViewById(R.id.text_12);
            textView_13 = (TextView) itemView.findViewById(R.id.text_13);
            textView_14 = (TextView) itemView.findViewById(R.id.text_14);
            textView_15 = (TextView) itemView.findViewById(R.id.text_15);
            textView_16 = (TextView) itemView.findViewById(R.id.text_16);
            textView_17 = (TextView) itemView.findViewById(R.id.text_17);
            textView_18 = (TextView) itemView.findViewById(R.id.text_18);
            textView_19 = (TextView) itemView.findViewById(R.id.text_19);

        }
    }
}