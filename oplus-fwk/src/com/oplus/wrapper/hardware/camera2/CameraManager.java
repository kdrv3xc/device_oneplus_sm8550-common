package com.oplus.wrapper.hardware.camera2;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class CameraManager {
    private final android.hardware.camera2.CameraManager mCameraManager;

    public CameraManager(android.hardware.camera2.CameraManager cameraManager) {
        this.mCameraManager = cameraManager;
    }

    public void openCamera(String str, int i, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException {
        this.mCameraManager.openCamera(str, i, executor, stateCallback);
    }
}
