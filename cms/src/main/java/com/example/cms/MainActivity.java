package com.example.cms;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cms.helper.CameraHelper;
import com.example.cms.view.CameraPreview;

public class MainActivity extends Activity implements View.OnClickListener {
    private Camera mCamera;
    private CameraPreview mPreview;
    private CameraHelper cameraHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mCamera = Camera.open();
        mPreview = (CameraPreview) findViewById(R.id.camera_preview);
        cameraHelper = CameraHelper.init(mPreview.getHolder(), mCamera);
        findViewById(R.id.btn_camera_change).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_camera_change:
                Log.i("onclick", "按钮");
                cameraHelper.changCamera();
                break;

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
//        releaseMediaRecorder();       // if you are using MediaRecorder, release it first
        releaseCamera();              // release the camera immediately on pause event
    }

//    private void releaseMediaRecorder() {
//        if (mMediaRecorder != null) {
//            mMediaRecorder.reset();   // clear recorder configuration
//            mMediaRecorder.release(); // release the recorder object
//            mMediaRecorder = null;
//            mCamera.lock();           // lock camera for later use
//        }
//    }

    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
    }


//    private PictureCallback mPicture = new PictureCallback() {
//
//        @Override
//        public void onPictureTaken(byte[] data, Camera camera) {
//
//            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
//            if (pictureFile == null) {
//                Log.d(TAG, "Error creating media file, check storage permissions: " +
//                        e.getMessage());
//                return;
//            }
//
//            try {
//                FileOutputStream fos = new FileOutputStream(pictureFile);
//                fos.write(data);
//                fos.close();
//            } catch (FileNotFoundException e) {
//                Log.d(TAG, "File not found: " + e.getMessage());
//            } catch (IOException e) {
//                Log.d(TAG, "Error accessing file: " + e.getMessage());
//            }
//        }
//    };
//
//    protected void onPause() {
//        super.onPause();
//        releaseMediaRecorder();       // if you are using MediaRecorder, release it first
//        releaseCamera();              // release the camera immediately on pause event
//    }


}
