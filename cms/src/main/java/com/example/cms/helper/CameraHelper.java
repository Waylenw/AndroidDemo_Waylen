package com.example.cms.helper;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created 王祥磊 on 2015/10/22.
 */
public class CameraHelper {

    private int cameraPosition = 1;//默认后置摄像头

    private SurfaceHolder surfaceHolder;
    private Camera mCamera;

    private static int camera_front_index = -1;
    private static int camera_back_index = -1;

    private CameraHelper(SurfaceHolder surfaceHolder, Camera mCamera) {
        this.surfaceHolder = surfaceHolder;
        this.mCamera = mCamera;
        surfaceHolder.addCallback(surfaceCallBack);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    /**
     * 初始化操作
     *
     * @param holder
     * @param camera
     * @return
     */
    public static CameraHelper init(SurfaceHolder holder, Camera camera) {
        CameraHelper cameraHelper = new CameraHelper(holder, camera);
        return cameraHelper;
    }

    SurfaceHolder.Callback surfaceCallBack = new SurfaceHolder.Callback() {
        /**
         * surface创建时会调用此方法
         * @param holder
         */
        public void surfaceCreated(SurfaceHolder holder) {
            try {
//            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);//得到窗口管理器
//            Display display = wm.getDefaultDisplay();//得到当前屏幕
                holder.setKeepScreenOn(true);
                Camera.Parameters parameters = mCamera.getParameters();//得到摄像头的参数
                parameters.setPreviewSize(1080, 1920);//设置预览照片的大小
                parameters.setPreviewFrameRate(3);//设置每秒3帧
                parameters.setPictureFormat(PixelFormat.JPEG);//设置照片的格式
                parameters.setJpegQuality(95);//设置照片的质量
                parameters.setPictureSize(1080, 1920);//设置照片的大小，默认是和     屏幕一样大
//            mCamera.setParameters(parameters);
//            isPreview = true;//设置是否预览参数为真
                mCamera.setDisplayOrientation(90);
                mCamera.startPreview();
                mCamera.setPreviewDisplay(holder);
            } catch (IOException e)

            {
                Log.d("TAg", "Error setting camera preview: " + e.getMessage());
            }

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            // If your preview can change or rotate, take care of those events here.
            // Make sure to stop the preview before resizing or reformatting it.

            if (null == surfaceHolder.getSurface()) {
                //此时surface预览已经不存在了
                return;
            }

            // stop preview before making changes
            try {
                mCamera.stopPreview();
            } catch (Exception e) {
            }

            // set preview size and make any resize, rotate or
            // reformatting changes here

            // start preview with new settings
            try {
                mCamera.setPreviewDisplay(surfaceHolder);
                mCamera.startPreview();

            } catch (Exception e) {
                Log.d("Tag", "Error starting camera preview: " + e.getMessage());
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            //surface已经销毁，在这里可以做释放的操作
        }

    };

    /**
     * 切换前后摄像头
     */
    public void changCamera() {
        //判断上次是否已经记录摄像头的下标
        if (cameraPosition == 1 && camera_front_index != -1) {
            changeCameraForFacing(camera_front_index);
            Log.i("tag", "后置切换前置1");
            return;
        } else if (cameraPosition == 0 && camera_back_index != -1){
            changeCameraForFacing(camera_back_index);
            Log.i("tag", "前置切换后置1");
            return;
        }

        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int cameraCount = Camera.getNumberOfCameras();//得到摄像头的个数
        for (int i = 0; i < cameraCount; i++) {
            Camera.getCameraInfo(i, cameraInfo);//得到第i个摄像头的信息
            if (cameraPosition == 1 && cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                //后置切换前置
                camera_front_index=i;
                changeCameraForFacing(i);
                Log.i("tag","后置切换前置");
                break;
            } else if (cameraPosition == 0 && cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                camera_back_index=i;
                changeCameraForFacing(i);
                Log.i("tag", "前置切换后置");
                break;
            }
        }
    }

    /***
     * 切换摄像头根据摄像头的下标
     *
     * @param index
     */
    private void changeCameraForFacing(int index) {
        mCamera.stopPreview();//停掉原来摄像头的预览
        mCamera.release();//释放资源
        mCamera = null;//取消原来摄像头
        mCamera = Camera.open(index);//打开当前选中的摄像头
        try {
            Camera.Parameters parameters = mCamera.getParameters();//得到摄像头的参数
            parameters.setPreviewSize(176, 144);//设置预览照片的大小
            parameters.setPreviewFrameRate(3);//设置每秒3帧
            parameters.setPictureFormat(PixelFormat.JPEG);//设置照片的格式
            parameters.setJpegQuality(95);//设置照片的质量
//            mCamera.setParameters(parameters);
//            isPreview = true;//设置是否预览参数为真
            mCamera.setDisplayOrientation(90);
            mCamera.startPreview();
            mCamera.setPreviewDisplay(surfaceHolder);//通过surfaceview显示取景画面
        } catch (IOException e) {
            e.printStackTrace();
        }

        //更改当前摄像头的标注
        if(cameraPosition==1){
            cameraPosition=0;
        }else{
            cameraPosition=1;
        }
    }


    /**
     * 根据手机方向获得相机预览画面旋转的角度
     *
     * @param context
     * @return
     */
    public static int getPreviewDegree(Activity context) {
        // 获得手机的方向
        int rotation = context.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degree = 0;
        // 根据手机的方向计算相机预览画面应该选择的角度
        switch (rotation) {
            case Surface.ROTATION_0:
                degree = 90;
                break;
            case Surface.ROTATION_90:
                degree = 0;
                break;
            case Surface.ROTATION_180:
                degree = 270;
                break;
            case Surface.ROTATION_270:
                degree = 180;
                break;
        }
        return degree;
    }

}
