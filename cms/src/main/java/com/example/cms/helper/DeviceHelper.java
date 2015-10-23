package com.example.cms.helper;

import android.hardware.Camera;

import java.util.List;

/**
 * Created 王祥磊 on 2015/10/23.
 */
public class DeviceHelper {
    /**
     * 开启闪光灯
     *
     * @param mCamera
     * @param action Camera.Parameters.FLASH_MODE_TORCH 或者 Camera.Parameters.FLASH_MODE_OFF
     */
    public static void turnLightOn(Camera mCamera, String action) {
        if (null == mCamera) {
            return;

        }
        Camera.Parameters parameters = mCamera.getParameters();
        if (null == parameters) {
            return;

        }
        List<String> flashModes = parameters.getSupportedFlashModes();
        if (flashModes == null) {
            return;

        }
        String flashMode = parameters.getFlashMode();

        if (!Camera.Parameters.FLASH_MODE_TORCH.equals(flashMode) && action.equals(Camera.Parameters.FLASH_MODE_TORCH)) {
            if (flashModes.contains(Camera.Parameters.FLASH_MODE_TORCH)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(parameters);
            }
        }
        if (!Camera.Parameters.FLASH_MODE_OFF.equals(flashMode) && action.equals(Camera.Parameters.FLASH_MODE_OFF)) {
            if (flashModes.contains(Camera.Parameters.FLASH_MODE_OFF)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
            }
        }

    }
}
