package com.perry.di.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.perry.di.R;
import com.perry.http.parser.ConfigXmlParser;
import com.perry.http.parser.HttpUrlEntry;

/**
 * Created by lipengjun on 2016/11/30.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestViewHolder> {

    private static final String TAG = "RequestAdapter";
    Activity activity;
    public RequestAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public RequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder, i: " + viewType);
        View view = LayoutInflater.from(activity).inflate(R.layout.item_request, parent,false);
//        View view = View.inflate(activity,R.layout.item_request, null);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        view.setLayoutParams(lp);
        return new RequestViewHolder(view, onRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(RequestViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder, position: " + position + ", holder: " + holder);
        holder.position = position;
        HttpUrlEntry httpUrlEntry = ConfigXmlParser.getPluginEntries().get(position);
        holder.setEntry(httpUrlEntry);
        if(httpUrlEntry.urlAddress.equals("http://114.251.8.193/api/copyrightrza/statistics")){
            holder.linearRza.setVisibility(View.VISIBLE);
            holder.linearRzc.setVisibility(View.GONE);
        }else if(httpUrlEntry.urlAddress.equals("http://114.251.8.193/api/copyrightrzc/statistics")){
            holder.linearRza.setVisibility(View.GONE);
            holder.linearRzc.setVisibility(View.VISIBLE);
        }else{
            holder.linearRza.setVisibility(View.GONE);
            holder.linearRzc.setVisibility(View.GONE);
        }
        holder.nameTextView.setText(httpUrlEntry.urlTitle);
        holder.valueTextView.setText(httpUrlEntry.urlAddress);
    }

    @Override
    public int getItemCount() {
        return ConfigXmlParser.getPluginEntries().size();
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public interface OnRecyclerViewListener {
        void onItemClick(int position);

        void onItemClick(int position,HttpUrlEntry httpUrlEntry);

        void onItemClick(int position,HttpUrlEntry httpUrlEntry,String keyStr,String categoryColumn);

        boolean onItemLongClick(int position);
    }
}

class RequestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    private static final String TAG = "RequestViewHolder";
    public View rootView;
    public TextView nameTextView;
    public TextView valueTextView;
    public int position;
    HttpUrlEntry entry;
    public String categoryColumn;//搜索类型
    RequestAdapter.OnRecyclerViewListener onRecyclerViewListener;

    public LinearLayout linearRza;
    public LinearLayout linearRzc;
    public Button buttonSearch;
    public EditText editText;

    public CheckBox checkbox1;
    public CheckBox checkbox2;
    public CheckBox checkbox3;
    public CheckBox checkbox4;
    public CheckBox checkbox5;
    public CheckBox checkbox6;

    public RequestViewHolder(View itemView, RequestAdapter.OnRecyclerViewListener onRecyclerViewListener) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.item_tv_request_name);
        valueTextView = (TextView) itemView.findViewById(R.id.item_tv_request_value);
        rootView = itemView.findViewById(R.id.item_request_linear);
        linearRza = (LinearLayout)itemView.findViewById(R.id.linear_rza);
        linearRzc = (LinearLayout)itemView.findViewById(R.id.linear_rzc);
        buttonSearch= (Button)itemView.findViewById(R.id.button_search);
        editText = (EditText)itemView.findViewById(R.id.edit_input);
        checkbox1 = (CheckBox)itemView.findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox)itemView.findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox)itemView.findViewById(R.id.checkbox3);
        checkbox4 = (CheckBox)itemView.findViewById(R.id.checkbox4);
        checkbox5 = (CheckBox)itemView.findViewById(R.id.checkbox5);
        checkbox6 = (CheckBox)itemView.findViewById(R.id.checkbox6);
        this.onRecyclerViewListener = onRecyclerViewListener;
        rootView.setOnClickListener(this);
        rootView.setOnLongClickListener(this);
        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.e(TAG, "position:" + position);
        if (null != onRecyclerViewListener) {
            onRecyclerViewListener.onItemClick(position);
            onRecyclerViewListener.onItemClick(position,entry);
            if(entry.urlAddress.equals("http://114.251.8.193/api/copyrightrza/statistics")) {
                categoryColumn = rzaCategoryColumn(checkbox1, checkbox2, checkbox3);
            }else if(entry.urlAddress.equals("http://114.251.8.193/api/copyrightrzc/statistics")){
                categoryColumn = rzcCategoryColumn(checkbox4, checkbox5, checkbox6);
            }
            onRecyclerViewListener.onItemClick(position,entry,editText.getText().toString(),categoryColumn);
        }

    }

    public String rzaCategoryColumn(CheckBox checkbox1,CheckBox checkbox2,CheckBox checkbox3){
        String[] rzaCategoryColumn = {"TCS","TCSS","RY"};
        String str = "";
        if(checkbox1.isChecked()){
            str = rzaCategoryColumn[0];
        }
        if(checkbox2.isChecked()){
            if(str.length()==0){
                str =rzaCategoryColumn[1];
            }else{
                str +=";"+rzaCategoryColumn[1];
            }
        }
        if(checkbox3.isChecked()){
            if(str.length()==0){
                str =rzaCategoryColumn[2];
            }else{
                str +=";"+rzaCategoryColumn[2];
            }
        }
        return str;
    }
    public String rzcCategoryColumn(CheckBox checkbox1,CheckBox checkbox2,CheckBox checkbox3){
        String[] rzcCategoryColumn= {"SWRN","TCS","RY"};
        String str = "";
        if(checkbox1.isChecked()){
            str = rzcCategoryColumn[0];
        }
        if(checkbox2.isChecked()){
            if(str.length()==0){
                str =rzcCategoryColumn[1];
            }else{
                str +=";"+rzcCategoryColumn[1];
            }
        }
        if(checkbox3.isChecked()){
            if(str.length()==0){
                str =rzcCategoryColumn[2];
            }else{
                str +=";"+rzcCategoryColumn[2];
            }
        }
        return str;
    }

    @Override
    public boolean onLongClick(View view) {
        if (null != onRecyclerViewListener) {
            onRecyclerViewListener.onItemLongClick(position);
        }
        return false;
    }

    public void setEntry(HttpUrlEntry entry) {
        this.entry = entry;
    }
}
