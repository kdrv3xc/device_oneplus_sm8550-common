package android.hardware.camera2.impl;

import android.app.ActivityThread;
import android.os.SystemProperties;

/* loaded from: classes.dex */
public class CameraCaptureSessionImplExtImpl implements ICameraCaptureSessionImplExt {
    private static final String TAG = "CameraCaptureSessionImplExtImpl";

    public CameraCaptureSessionImplExtImpl(Object obj) {
    }

    @Override // android.hardware.camera2.impl.ICameraCaptureSessionImplExt
    public boolean modifySkipUnconfigFlag(boolean z) {
        String currentPackageName = ActivityThread.currentPackageName();
        String str = SystemProperties.get("ro.oplus.system.camera.name", "");
        if (currentPackageName != null && currentPackageName.equals(str)) {
            return true;
        }
        return z;
    }
}
