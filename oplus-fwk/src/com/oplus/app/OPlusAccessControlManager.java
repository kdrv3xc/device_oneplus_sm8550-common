package com.oplus.app;

import android.os.UserHandle;

/* loaded from: classes.dex */
public class OPlusAccessControlManager {
    private static volatile OPlusAccessControlManager sInstance = null;
    public static final int USER_CURRENT = UserHandle.myUserId();

    private OPlusAccessControlManager() {
    }

    public static OPlusAccessControlManager getInstance() {
        if (sInstance == null) {
            synchronized (OPlusAccessControlManager.class) {
                if (sInstance == null) {
                    sInstance = new OPlusAccessControlManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isEncryptPass(String str, int i) {
        return true;
    }

    public boolean isEncryptedPackage(String str, int i) {
        return true;
    }
}
