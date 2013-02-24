package snow.photo.viewer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ImageClickListener implements OnClickListener {

	Context context;
	
	String strURL;
	
	public ImageClickListener(Context context, String strURL){
		this.context=context;
		this.strURL=strURL;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent=new Intent(context, ImageActivity.class);
		intent.putExtra("image ID", strURL);
		context.startActivity(intent);
	}

}
