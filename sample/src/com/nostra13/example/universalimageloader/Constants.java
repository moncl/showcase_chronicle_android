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

import android.util.Log;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public final class Constants {
	
	
	public static final String productsJsonUrl = "http://chilchil.me/products.json";
	public static final String[] IMAGES = new String[] {
			"http://uiimage.dnshop.co.kr/eventfile/C803_20100706105949/20100809_SOUP.jpg",
			"http://uiimage.dnshop.co.kr/eventfile/C803_20100706105949/20100809_SOUP.jpg",
			"http://data.ygosu.com/editor/attach/2/20120111/fDeHaM84S4CVJuG.jpg",
			"http://data.ygosu.com/editor/attach/2/20120111/fDeHaM84S4CVJuG.jpg",
			"http://uiimage.dnshop.co.kr/eventfile/C803_20100706105949/20100809_SOUP.jpg",
			"http://data.ygosu.com/editor/attach/2/20120111/fDeHaM84S4CVJuG.jpg",
			
	};
	
//	public static final String[] Photo = new String[] {};
	
	public static JSONObject photoObject = new JSONObject();
	public static JSONArray PhotoArray = new JSONArray();
	
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
					}
				}
			} 
		}catch(Exception e) {
			e.printStackTrace();
			String error = e.toString();
			Log.d("wqe",error);
		}  
	}
//		for(int i=0; i>10; i++) 
//		{
//			JSONObject JObject = new JSONObject();
//			try
//			{
//				JObjec
//			} // JSON Photo받아오는거 작업중. 
//		}
//	}
//
//	
//	//test
	private Constants() {
	}

	public static class Config {
		public static final boolean DEVELOPER_MODE = false;
	}
	
	public static class Extra {
		public static final String PhotoImages = "com.nostra13.example.universalimageloader.PhotoArray";
		public static final String IMAGES = "com.nostra13.example.universalimageloader.IMAGES";
		public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";

	}
}
