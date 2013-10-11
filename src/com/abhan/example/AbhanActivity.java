package com.abhan.example;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AbhanActivity extends ListActivity {
	private static final String TAG = AbhanActivity.class.getSimpleName();
	private static String items[] = { "Category Wise", "Call Average", "Employee Activity"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abhan);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				AbhanActivity.this,
			      android.R.layout.simple_expandable_list_item_1,
			      items);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);
		String text = " position:" + position + "  " + items[position];
		android.util.Log.i(TAG, "Clicked " + text);
	}
}