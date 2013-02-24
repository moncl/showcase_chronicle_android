package me.blog.netrance.example.image_grid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class ImageGridActivity extends Activity {
    
    //------------------------------------------------------------
    // imageIDs �迭�� GridView �並 �����ϴ� �̹��� ���ϵ��� ���ҽ� ID���� ����ϴ�.
    
    private int[] imageIDs = new int[] {
        R.drawable.gallery_image_02,
        R.drawable.gallery_image_02,
        R.drawable.gallery_image_03,
        R.drawable.gallery_image_04,
        R.drawable.gallery_image_05,
        R.drawable.gallery_image_06,
        R.drawable.gallery_image_07,
        R.drawable.gallery_image_08,
        R.drawable.gallery_image_01,
        R.drawable.gallery_image_10,
    };
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //-----------------------------------------------------------------------
        // �������� ������ GridView ���� ����� ��ü�� �����ϰ� �װ��� �� ���� ����ͷ� �����մϴ�.
        
        GridView gridViewImages = (GridView)findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this, imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);
    }
}