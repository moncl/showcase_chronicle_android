package com.example.test5;

import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		SmartImageView myImage = (SmartImageView) this.findViewById(R.id.my_image);
		myImage.setImageUrl("http://images.nationalgeographic.com/wpf/media-live/photos/000/004/cache/african-elephant_435_600x450.jpg");
		//myImage.setImageContact(contactAddressBookId);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
