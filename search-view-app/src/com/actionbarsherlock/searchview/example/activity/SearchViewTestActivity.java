package com.actionbarsherlock.searchview.example.activity;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.searchview.example.R;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.searchview.OnCloseListener;
import com.actionbarsherlock.widget.searchview.OnQueryTextListener;
import com.actionbarsherlock.widget.searchview.OnSuggestionListener;
import com.actionbarsherlock.widget.searchview.SearchView;
import com.actionbarsherlock.widget.searchview.internal.ISearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;

public class SearchViewTestActivity extends SherlockActivity 
                                    implements OnQueryTextListener,
                                               OnCloseListener, 
                                               OnFocusChangeListener,
                                               OnSuggestionListener,
                                               OnClickListener {
    
    public static final class Dark extends SearchViewTestActivity {    
    }
    
    public static final class Light extends SearchViewTestActivity {    
    }
    
    public static final class LightWithDarkActionBar extends SearchViewTestActivity {    
    }
    

    private static final String TAG = "SearchViewSelfTest";
    
    private Button mButton;
    private SearchView mSearchView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        getSupportActionBar().setTitle("Self Test");
        
        mButton = (Button)findViewById(R.id.test);
        mButton.setOnClickListener(this);
        
        mSearchView = new SearchView(this);
        mSearchView.setOnQueryTextListener(this);       
        mSearchView.setOnCloseListener(this);
        mSearchView.setOnQueryTextFocusChangeListener(this);
        mSearchView.setOnSuggestionListener(this);
        mSearchView.setOnSearchClickListener(this);
    }
    
    @Override    
    public boolean onCreateOptionsMenu(Menu menu) {        
        MenuItem item = menu.add("search");
        item.setIcon(android.R.drawable.ic_menu_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setActionView(mSearchView);
        return true;
    }
    
    private void selfTest() {
        ISearchView isv = mSearchView;
        isv.setFocusable(false);
        isv.setFocusable(true); 
        isv.setImeOptions(0);
        isv.getImeOptions();
        isv.setInputType(0);
        isv.getInputType();
        isv.setMaxWidth(500);
        isv.getMaxWidth();
        isv.setQueryRefinementEnabled(true);
        isv.setQueryRefinementEnabled(false);
        isv.isQueryRefinementEnabled();
        isv.setSubmitButtonEnabled(true);
        isv.setSubmitButtonEnabled(false);
        isv.isSubmitButtonEnabled();
        isv.setSuggestionsAdapter(null);
        isv.getSuggestionsAdapter();
        isv.setQuery("test", false);
        isv.setQuery("test", true);
        isv.getQuery();
        isv.setQueryHint("test hint");
        isv.getQueryHint();
        isv.setSearchableInfo(null);
        isv.clearFocus();
        isv.setIconified(false);
        isv.setIconified(true);
        isv.isIconified();
        isv.setIconifiedByDefault(false);
        isv.setIconifiedByDefault(true);
        isv.isIconfiedByDefault();
    }
    
    @Override
    public void onClick(View v) {
        if (v == mButton) {
            selfTest();
        } else if (v == mSearchView) { 
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
