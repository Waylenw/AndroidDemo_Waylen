package com.example.tintingclipping;

import android.app.Activity;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                imageView.setImageTintMode(PorterDuff.Mode.ADD);
                break;
            case R.id.btn_clear:
                imageView.setImageTintMode(PorterDuff.Mode.CLEAR);
                break;
            case R.id.btn_multiply:
                imageView.setImageTintMode(PorterDuff.Mode.MULTIPLY);
                break;
            case R.id.btn_src_in:
                imageView.setImageTintMode(PorterDuff.Mode.SRC_IN);
                break;
            case R.id.btn_src_out:
                imageView.setImageTintMode(PorterDuff.Mode.SRC_OUT);
                break;
            case R.id.btn_src_over:
                imageView.setImageTintMode(PorterDuff.Mode.SRC_OVER);
                break;
            case R.id.btn_src_screen:
                imageView.setImageTintMode(PorterDuff.Mode.SCREEN);
                break;
        }
    }

    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
        @Override
        public void getOutline(View view, Outline outline) {

            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
        }
    };
    ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
        @Override
        public void getOutline(View view, Outline outline) {

            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2);
        }
    };
}
