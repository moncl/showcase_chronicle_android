package snow.photo.viewer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;

public class SnowPhotoViewer extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String [] strURLS = {"http://cfile25.uf.tistory.com/image/112CA2274C2220D2B47CB1", 
				"http://cfile24.uf.tistory.com/image/110475474D666C30382331",
				"http://cfile10.uf.tistory.com/image/160475474D666C343CD190",
				"http://germaneconsulting.com/wp-content/uploads/2011/12/Baby_elephant.jpg",
				"http://dnfsn.img14.kr/image/2013/02/12/09/09_02tee.jpg"
        };

        GridView gv = (GridView)findViewById(R.id.gvGridView);
        ImageAdapter imgAdapter = new ImageAdapter(strURLS);

        gv.setAdapter(imgAdapter);

        
        gv.setOnItemClickListener(new OnItemClickListener() {    
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               
            }
        });
    }
    
}