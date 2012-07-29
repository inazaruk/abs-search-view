abs-search-view
===============

Backport of SearchView (with limited functionality). Requires ActionBarSherlock.

The `SearchView` from this library acts as a switch: if current API level is <= 10 a `CompathSearchView` 
instance is used as backend, but if API level is >= 11 then native `android.widget.SearchView` is used. 
Thus all features that were not backported in `CompatSearchView` are still supported on platofrms >= 11 
when `android.widget.SearchView` was first introduced.

The code that uses `SearchView` from this library is identical to code that is needed for
`android.widget.SearchView`. Which means that backporting existing applications shouldn't be too hard. 
But since there are some features missing, application's user experience might be affected.

What is not supported in `CompatSearchView`: 
- Voice Button
- Searchable Configuration (which implies a lot of features that are not supported)
  - `setSearchableInfo()` does nothing
- Custom Suggestions Adapter 
  - `setSuggestionsAdapter()`/`getSuggestionsAdapter()` do nothing 
  - `setQueryRefinementEnabled()`/`isQueryRefinementEnabled()` do nothing


