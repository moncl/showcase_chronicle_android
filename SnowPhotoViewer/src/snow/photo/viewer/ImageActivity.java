package snow.photo.viewer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_image);
        
        //----------------------------------------------------------------
        // Ȯ��Ǵ� �̹����� �����ֱ� ���� ImageView �並 �����մϴ�.
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        setImage(imageView);
    }
    
	private void setImage(ImageView imageView) {
        //----------------------------------------------------------------
        // �ʱ� ��Ƽ��Ƽ�� GridView ���� �̹��� �׸��� Ŭ���� �� ������ ����Ʈ��
        // �� ��Ƽ��Ƽ�� getIntent �޼ҵ带 ȣ���Ͽ� ������ �� �ֽ��ϴ�.
        Intent receivedIntent = getIntent();
        
        //----------------------------------------------------------------
        // Ȯ��Ǵ� �̹����� ���ҽ� ID�� ����Ʈ�κ��� �о���̰�,
        // �װ��� ImageView ���� �̹��� ���ҽ��� �����մϴ�.
        
        int imageID = (Integer)receivedIntent.getExtras().get("image ID");
        imageView.setImageResource(imageID);
    }
}


