package com.oplus.wrapper.os;

import android.os.IBinder;

/* loaded from: classes.dex */
public class ServiceManager {
    public static IBinder checkService(String str) {
        return android.os.ServiceManager.checkService(str);
    }

    public static IBinder getService(String str) {
        return android.os.ServiceManager.getService(str);
    }

    public static void addService(String str, IBinder iBinder) {
        android.os.ServiceManager.addService(str, iBinder);
    }
}
