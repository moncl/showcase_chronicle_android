package com.nostra13.example.universalimageloader;

import java.util.ArrayList;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainTabActivity extends TabActivity {
	TabHost tabHost;	
	ArrayList<String> tmp_tabname;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		tmp_tabname = i.getStringArrayListExtra("Tabnames");
		
		Log.d("sdadsa",tmp_tabname.toString());
		setContentView(R.layout.tabmain);
		tabHost = getTabHost();
		setTabs();
		
	}
	private void setTabs()
	{
		addTab(tmp_tabname.get(0).toString(), R.drawable.tab_home, ImageGridActivity.class,"http://moncl.net:8888/categories/1/products.json");
		addTab(tmp_tabname.get(1).toString(), R.drawable.tab_home, ImageGridActivity.class,"http://moncl.net:8888/categories/2/products.json");
		addTab(tmp_tabname.get(2).toString(), R.drawable.tab_home, ImageGridActivity.class,"http://moncl.net:8888/categories/3/products.json");
		addTab(tmp_tabname.get(3).toString(), R.drawable.tab_home, ImageGridActivity.class,"http://moncl.net:8888/categories/4/products.json");
	}
	private void addTab(String labelId, int drawableId, Class<?> c, String ImageJsonURL)
	{
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		intent.putExtra("imagejsonurl",ImageJsonURL);
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		//ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		//icon.setImageResource(drawableId);
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
}
