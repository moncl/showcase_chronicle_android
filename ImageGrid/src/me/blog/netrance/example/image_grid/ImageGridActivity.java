package me.blog.netrance.example.image_grid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class ImageGridActivity extends Activity {
    
    //------------------------------------------------------------
    // imageIDs 배열은 GridView 뷰를 구성하는 이미지 파일들의 리소스 ID들을 담습니다.
    
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
        // 사진들을 보여줄 GridView 뷰의 어댑터 객체를 정의하고 그것을 이 뷰의 어댑터로 설정합니다.
        
        GridView gridViewImages = (GridView)findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this, imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);
    }
}