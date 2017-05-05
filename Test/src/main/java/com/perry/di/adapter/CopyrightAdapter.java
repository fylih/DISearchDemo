package com.perry.di.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.perry.di.R;

public class CopyrightAdapter extends RecyclerView.Adapter{

    private Context context;
    private LayoutInflater mLayoutInflater;
    public CopyrightAdapter(Context context){
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_copyright,parent,false);
        return new CopyRightHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CopyRightHolder extends ViewHolder{

        public CopyRightHolder(View itemView) {
            super(itemView);
        }
    }
}