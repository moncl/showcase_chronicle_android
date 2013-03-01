package com.example.test5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		String [] strURLS = {"http://cfile25.uf.tistory.com/image/112CA2274C2220D2B47CB1", 
				"http://cfile24.uf.tistory.com/image/110475474D666C30382331",
				"http://cfile10.uf.tistory.com/image/160475474D666C343CD190",
				"http://germaneconsulting.com/wp-content/uploads/2011/12/Baby_elephant.jpg",
				"http://uiimage.dnshop.co.kr/eventfile/C803_20100706105949/20100809_SOUP.jpg"
				
        };
		
		
		 GridView gv = (GridView)findViewById(R.id.gvGridView);
	        ImageAdapter imgAdapter = new ImageAdapter(strURLS);

	        gv.setAdapter(imgAdapter);
	        
	}

		
		
		//SmartImageView myImage = (SmartImageView)findViewById(R.id.my_image);

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
