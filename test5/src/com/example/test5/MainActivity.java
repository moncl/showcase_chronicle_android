package com.example.test5;

import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		SmartImageView myImage = (SmartImageView) this.findViewById(R.id.my_image);
		myImage.setImageUrl("http://uiimage.dnshop.co.kr/eventfile/C803_20100706105949/20100809_SOUP.jpg");
		//myImage.setImageContact(contactAddressBookId);
	
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int deviceWidth = displayMetrics.widthPixels;
		int deviceHeight =displayMetrics.heightPixels;
		
		TextView size_text=(TextView) findViewById(R.id.text);
		size_text.setText(deviceHeight);
		size_text.setText(deviceWidth);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
