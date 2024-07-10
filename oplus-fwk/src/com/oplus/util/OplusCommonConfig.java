package com.oplus.util;

import android.app.OplusActivityManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;

/* loaded from: classes.dex */
public final class OplusCommonConfig {
    private static final String TAG = "OplusCommonConfig";
    private static OplusCommonConfig sInstance = null;
    private OplusActivityManager mOppoAm;

    private OplusCommonConfig() {
        this.mOppoAm = null;
        this.mOppoAm = new OplusActivityManager();
    }

    public static OplusCommonConfig getInstance() {
        if (sInstance == null) {
            sInstance = new OplusCommonConfig();
        }
        return sInstance;
    }

    public boolean putConfigInfo(String str, Bundle bundle, int i) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager == null) {
            return false;
        }
        try {
            return oplusActivityManager.putConfigInfo(str, bundle, i, UserHandle.myUserId());
        } catch (RemoteException e) {
            Log.e(TAG, "putConfigInfo " + str + " failed!");
            return false;
        }
    }

    public boolean putConfigInfoAsUser(String str, Bundle bundle, int i, int i2) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager == null) {
            return false;
        }
        try {
            return oplusActivityManager.putConfigInfo(str, bundle, i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "putConfigInfoAsUser " + str + " failed!");
            return false;
        }
    }

    public Bundle getConfigInfo(String str, int i) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager == null) {
            return null;
        }
        try {
            return oplusActivityManager.getConfigInfo(str, i, UserHandle.myUserId());
        } catch (RemoteException e) {
            Log.e(TAG, "getConfigInfo " + str + " failed!");
            return null;
        }
    }

    public Bundle getConfigInfoAsUser(String str, int i, int i2) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager == null) {
            return null;
        }
        try {
            return oplusActivityManager.getConfigInfo(str, i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "getConfigInfoAsUser " + str + " failed!");
            return null;
        }
    }
}
