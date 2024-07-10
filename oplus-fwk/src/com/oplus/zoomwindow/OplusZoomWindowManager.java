package com.oplus.zoomwindow;

/* loaded from: classes.dex */
public class OplusZoomWindowManager {
    public static OplusZoomWindowManager sOplusZoomWindowManager = null;

    public static OplusZoomWindowManager getInstance() {
        if (sOplusZoomWindowManager == null) {
            sOplusZoomWindowManager = new OplusZoomWindowManager();
        }
        return sOplusZoomWindowManager;
    }

    public boolean registerZoomWindowObserver(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
        return false;
    }

    public boolean unregisterZoomWindowObserver(IOplusZoomWindowObserver iOplusZoomWindowObserver) {
        return false;
    }
}
