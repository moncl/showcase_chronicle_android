/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snow.photo.viewer;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	Context context;
	private final ImageDownloader imageDownloader = new ImageDownloader();
	private String[] strURLList;
    
	public ImageAdapter(Context context,String _strURLList[])
	{
		if (_strURLList != null) 
		{
			this.context=context;
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
        
        ImageClickListener imageViewClickListener
        = new ImageClickListener(context, strURLList[position]);
        view.setOnClickListener(imageViewClickListener);
    
        return view;
    }

    public ImageDownloader getImageDownloader() 
    {
        return imageDownloader;
    }
}
