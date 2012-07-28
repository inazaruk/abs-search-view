package com.actionbarsherlock.searchview.example.adapter;

import com.actionbarsherlock.searchview.example.R;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class ExampleListAdapter extends BaseAdapter {

    private final PackageManager mPackageManager;
    private final LayoutInflater mInflater;
    private final List<Intent> mExamples;
    public ExampleListAdapter(Context context, List<Intent> intents) {
        mPackageManager = context.getPackageManager();
        mInflater = LayoutInflater.from(context);
        mExamples = Collections.unmodifiableList(intents);
    }
    
    @Override
    public int getCount() {
        return mExamples.size();
    }
    
    @Override
    public Intent getItem(int position) {
        return mExamples.get(position);
    }
    
    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_example, parent, false);
        }
        
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView descr = (TextView)view.findViewById(R.id.descr);
        
        ResolveInfo info = mPackageManager.resolveActivity(getItem(position), 0);
        title.setText(info.activityInfo.labelRes);
        descr.setText(info.activityInfo.descriptionRes);
        
        return view;
    }
    
}
