package com.nostra13.example.universalimageloader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class intro extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.intro);
		super.onCreate(savedInstanceState);
		ImageView itro_img=(ImageView)findViewById(R.id.intro_img);
		
		
		new Thread(new Runnable() {
			public void run() {
			
			try {
				Thread.sleep(2000);
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
			
			Intent i = new Intent(intro.this, HomeActivity.class);
			startActivity(i);
			finish();
		}
	}).start();
	}
}
