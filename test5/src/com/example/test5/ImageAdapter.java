package com.example.test5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;




public class ImageAdapter extends BaseAdapter {
		private final ImageDownloader imageDownloader = new ImageDownloader();
		private String[] strURLList;
		
		public ImageAdapter(String _strURLList[])
		{
			if (_strURLList != null) 
			{
				strURLList = _strURLList;
			}
		}
		
		public int getCount() 
		{
		    return strURLList.length;
		}
		
		public String getItem(int position) 
		{
		    return strURLList[position];
		}
		
		public long getItemId(int position) 
		{
		    return strURLList[position].hashCode();
		}
		
		public View getView(int position, View view, ViewGroup parent) 
		{
		    if (view == null) 
		    {
		        view = new ImageView(parent.getContext());
		        view.setLayoutParams(new GridView.LayoutParams(100, 100));
		        view.setPadding(5, 5, 5, 5);
		    }
		
		    imageDownloader.download(strURLList[position], (ImageView)view);
		    
		    return view;
		}
		
		public ImageDownloader getImageDownloader() 
		{
		    return imageDownloader;
		}
}
