/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.nostra13.example.universalimageloader;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.example.universalimageloader.Constants.Extra;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.PauseOnScrollListener;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class ImageGridActivity extends BaseActivity {

	String[] imageUrls;
	public static final String productsJsonUrl = "http://chilchil.me/products.json";
	DisplayImageOptions options;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_image_grid);
		
	
		Bundle bundle = getIntent().getExtras();
		imageUrls = bundle.getStringArray(Extra.IMAGES);
		
		//imageUrls=strURLS;

		options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub)
			.showImageForEmptyUri(R.drawable.ic_empty)
			.showImageOnFail(R.drawable.ic_error)
			.cacheInMemory()
			.cacheOnDisc()
			.bitmapConfig(Bitmap.Config.RGB_565)
			.build();

		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter());
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				startImagePagerActivity(position);
			}
		});
		gridView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));
	}

	private void startImagePagerActivity(int position) {
		Intent intent = new Intent(this, ImagePagerActivity.class);
		intent.putExtra(Extra.IMAGES, imageUrls);
		intent.putExtra(Extra.IMAGE_POSITION, position);
		startActivity(intent);
	}
	
	
	
//	
//	private class GetJsonTask extends AsyncTask<Void,Void,Void>{
//        protected void onPostExecute(Void params){
//                             Log.d("Hello","AsyncTask Start");
//            //dialog.dismiss();
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            // TODO Auto-generated method stub
//          //  mHandler.post(wait);
//        	getJsonPhoto();
//            return null;
//        }
//
//
//    }
	
	public static JSONObject photoObject = new JSONObject();
	public static JSONArray PhotoArray = new JSONArray();
	
	public static ArrayList<String> PhotoUrlArray = new ArrayList<String>();
	
	private void getJsonPhoto () {
		try{
			HttpParams params = new BasicHttpParams();
			HttpConnectionParams.setSoTimeout(params, 0);
			HttpClient httpClient = new DefaultHttpClient(params);
			
			HttpGet httpget = new HttpGet(productsJsonUrl);
			HttpEntity entity = httpClient.execute(httpget).getEntity();
			if(entity != null) {
				String response = EntityUtils.toString(entity);
				entity.consumeContent();
				
				httpClient.getConnectionManager().shutdown();
				
				if(PhotoArray !=null) {
					for(int i =0; i<PhotoArray.length(); i++) {
						
						String photoUrl = photoObject.getString("photo_file");
						PhotoUrlArray.add(photoUrl);
					}
				}
			} 
		}catch(Exception e) {
			e.printStackTrace();
			String error = e.toString();
			Log.d("wqe",error);
		}  
	}
	
	
	
	public class ImageAdapter extends BaseAdapter {
		ArrayList<String> PhotoUrlArray;
		//public ArrayList<String> array = new ArrayList<String>();
		@Override
		public int getCount() {
			return PhotoUrlArray.size();
		}

		@Override
		public Object getItem(int position) {
			return PhotoUrlArray.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ImageView imageView;
			if (convertView == null) {
				imageView = (ImageView) getLayoutInflater().inflate(R.layout.item_grid_image, parent, false);
			} else {
				imageView = (ImageView) convertView;
			}

			imageLoader.displayImage(imageUrls[position], imageView, options);

			return imageView;
		}
	}
}