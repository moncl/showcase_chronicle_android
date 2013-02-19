package com.example.galltest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageView view;
	private static final String LOG_TAG="MainActivity";
	private int[] IMAGES={
			R.drawable.image01,
			R.drawable.image02,
			R.drawable.image03,
			R.drawable.image04,
			R.drawable.image05,
			R.drawable.image06,
			R.drawable.image07,
			R.drawable.image08,
			R.drawable.image09,
			R.drawable.image10,
	};
	
	public  MainActivity(){
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		view=(ImageView)findViewById(R.id.view);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Gallery galleryImage=(Gallery)findViewById(R.id.gallery);
		galleryImage.setAdapter(new ImageAdapter(this));
		
		galleryImage.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				Toast.makeText(getBaseContext(), "image"+(position+1)+"select", Toast.LENGTH_SHORT).show();
				//view.setImageResource(IMAGES[0]);
			}
		});
	}
	
	public class ImageAdapter extends BaseAdapter{

		private Context mContext;
		private int iBackGround;
		
		public ImageAdapter (Context context){
			mContext=context;
			Log.v(LOG_TAG,"ImageAdapter");
			TypedArray typeArray=obtainStyledAttributes(R.styleable.Gallery);
			iBackGround=typeArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0);
			typeArray.recycle();
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return IMAGES.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return IMAGES[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			imageView=new ImageView(mContext);
			imageView.setImageResource(IMAGES[position]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(200,250));
			imageView.setBackgroundResource(iBackGround);
			
			return imageView;
		}
		
	}
}
