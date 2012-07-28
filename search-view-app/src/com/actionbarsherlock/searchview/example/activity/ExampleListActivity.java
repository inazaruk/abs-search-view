package com.actionbarsherlock.searchview.example.activity;

import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.searchview.example.adapter.ExampleListAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ExampleListActivity extends SherlockListActivity {
    
    private ExampleListAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {        
        super.onCreate(savedInstanceState);
        mAdapter = new ExampleListAdapter(this, createExampleList());        
        setListAdapter(mAdapter);
    }
    
  
    
    private List<Intent> createExampleList() {
        List<Intent> examples = new LinkedList<Intent>();
        examples.add(new Intent(this, DynamicSearchViewActivity.class));
        examples.add(new Intent(this, ResourceSearchViewActivity.class));
        examples.add(new Intent(this, SearchViewTestActivity.Dark.class));
        examples.add(new Intent(this, SearchViewTestActivity.Light.class));
        examples.add(new Intent(this, SearchViewTestActivity.LightWithDarkActionBar.class));
        return examples;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = mAdapter.getItem(position);
        startActivity(intent);
    }
}
