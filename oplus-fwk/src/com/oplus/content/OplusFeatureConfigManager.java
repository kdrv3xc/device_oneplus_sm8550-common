package com.oplus.content;

import android.os.RemoteException;

/* loaded from: classes.dex */
public class OplusFeatureConfigManager {
    private static OplusFeatureConfigManager sInstance = null;

    public static OplusFeatureConfigManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusFeatureConfigManager();
        }
        return sInstance;
    }

    public boolean hasFeature(String str) throws RemoteException {
        return false;
    }
}
