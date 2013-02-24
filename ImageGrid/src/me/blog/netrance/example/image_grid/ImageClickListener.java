package me.blog.netrance.example.image_grid;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ImageClickListener implements OnClickListener {

    Context context;
    
    //-----------------------------------------------------------
    // imageID�� Ȯ���ؼ� ������ �̹����� ���ҽ� ID�Դϴ�.
    
    int imageID;
    
    public ImageClickListener(Context context, int imageID) {
        this.context = context;
        this.imageID = imageID;
    }

    public void onClick(View v) {
        //---------------------------------------------------------
        // Ȯ��� �̹����� �����ִ� ��Ƽ��Ƽ�� �����ϱ� ���� ����Ʈ ��ü�� �����մϴ�.
        // �׸��� �� ��Ƽ��Ƽ�� ������ imageID�� ���� �� ��ü�� �����մϴ�.
        // ����Ʈ ��ü�� ���� �� �� ��Ƽ��Ƽ�� �����մϴ�.
        
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra("image ID", imageID);
        context.startActivity(intent);
    }
}
