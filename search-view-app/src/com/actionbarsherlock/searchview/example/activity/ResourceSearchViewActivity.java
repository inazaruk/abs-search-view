package com.actionbarsherlock.searchview.example.activity;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.searchview.example.R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.searchview.OnCloseListener;
import com.actionbarsherlock.widget.searchview.OnQueryTextListener;
import com.actionbarsherlock.widget.searchview.OnSuggestionListener;
import com.actionbarsherlock.widget.searchview.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;

/**
 * This is a very simple activity that shows how one can dynamically 
 * instantiate SearchView and it to action bar. Nor resources are required.
 *  
 * @author inazaruk
 */
public class ResourceSearchViewActivity extends SherlockActivity 
                                       implements OnQueryTextListener,
                                                  OnCloseListener, 
                                                  OnFocusChangeListener,
                                                  OnSuggestionListener,
                                                  OnClickListener {
           
    private static final String TAG = "ResourceSearchView";
    
    private SearchView mSearchView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        
        getSupportActionBar().setTitle(R.string.searchview);
        getSupportActionBar().setSubtitle(R.string.from_menu_resource);
    }
    
    
    @Override    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.search_view, menu);
        
        MenuItem item = menu.findItem(R.id.menu_search);
        mSearchView = (SearchView)item.getActionView();
        
        mSearchView.setQuery("Search Me", false); //Initial query
        mSearchView.setQueryHint("Search Hint"); 
        
        mSearchView.setOnQueryTextListener(this);       
        mSearchView.setOnCloseListener(this);
        mSearchView.setOnQueryTextFocusChangeListener(this);
        mSearchView.setOnSuggestionListener(this); //ignored on <= 10 (not supported)
        mSearchView.setOnSearchClickListener(this);
        
        return true;
    }
    
    @Override
    public void onClick(View v) {
        if (v == mSearchView) { 
            Log.e(TAG, "On SearchView 'search' click.");
        }
    }
    
    @Override
    public boolean onClose() {
        Log.e(TAG, "SearchView is about to close.");
        return false;
    }
    
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        Log.e(TAG, "SearchView focus changed.");        
    }
    
    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e(TAG, "SearchView text change: " + newText);
        return false;
    }
    
    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e(TAG, "SearchView text submit: " + query);
        return false;
    }
    
    @Override
    public boolean onSuggestionClick(int position) {
        Log.e(TAG, "SearchView suggestion click: " + position);
        return false;
    }
    
    @Override
    public boolean onSuggestionSelect(int position) {
        Log.e(TAG, "SearchView suggestion select: " + position);
        return false;
    }
}
