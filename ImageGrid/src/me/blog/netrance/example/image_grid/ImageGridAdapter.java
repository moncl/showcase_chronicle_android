package me.blog.netrance.example.image_grid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageGridAdapter extends BaseAdapter {
    
    Context context = null;
    
    //-----------------------------------------------------------
    // imageIDs�� �̹��� ���ϵ��� ���ҽ� ID���� ��� �迭�Դϴ�.
    // �� �迭�� ���ҵ��� �ڽ� ����� ImageView ����� ������ �����ִ�����
    // �����ϴµ� Ȱ��� ���Դϴ�.
    
    int[] imageIDs = null;
    
    public ImageGridAdapter(Context context, int[] imageIDs) {
        this.context = context;
        this.imageIDs = imageIDs;
    }

    public int getCount() {
        return (null != imageIDs) ? imageIDs.length : 0;
    }

    public Object getItem(int position) {
        return (null != imageIDs) ? imageIDs[position] : 0;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;
        
        if (null != convertView)
            imageView = (ImageView)convertView;
        else {
            //---------------------------------------------------------------
            // GridView �並 ������ ImageView ���� ��Ʈ���� �����մϴ�.
            // �׸��� �װ��� ũ�⸦ 320*240���� ���Դϴ�.
            // ũ�⸦ ���̴� ������ �޸� ���� ������ ���� �� �ֱ� �����Դϴ�.
            
            Bitmap bmp
                = BitmapFactory.decodeResource(context.getResources(), imageIDs[position]);
            bmp = Bitmap.createScaledBitmap(bmp, 320, 240, false);
            
            //---------------------------------------------------------------
            // GridView �並 ������ ImageView ����� �����մϴ�.
            // �信 ������ �̹����� �տ��� ������ ��Ʈ�� ��ü�Դϴ�.

            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setImageBitmap(bmp);
            
            //---------------------------------------------------------------
            // ������ ������� �ʴ� �ڵ��Դϴ�.
            //imageView.setMaxWidth(320);
            //imageView.setMaxHeight(240);
            //imageView.setImageResource(imageIDs[position]);
            
            //---------------------------------------------------------------
            // ���� �׸���� Ŭ���� ó���ϴ� ImageClickListener ��ü�� �����մϴ�.
            // �׸��� �װ��� ImageView�� Ŭ�� �����ʷ� �����մϴ�.
            
            ImageClickListener imageViewClickListener
                = new ImageClickListener(context, imageIDs[position]);
            imageView.setOnClickListener(imageViewClickListener);
        }
        
        return imageView;
    }

}
