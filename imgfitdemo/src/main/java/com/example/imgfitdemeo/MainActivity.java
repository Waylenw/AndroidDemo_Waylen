package com.example.imgfitdemeo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private MyFitImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (MyFitImageView) findViewById(R.id.ivImage);
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.timg);
        imageView.setImageBitmap(bitmap);
        imageView.setSize(bitmap.getWidth(),bitmap.getHeight());
    }
}
