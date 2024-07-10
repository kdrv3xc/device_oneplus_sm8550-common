package com.oplus.osense;

import android.util.Log;
import java.util.HashMap;

/* loaded from: classes.dex */
public class OsenseResClient {
    private static HashMap<String, OsenseResClient> sOsenseResClientMap = new HashMap<>();
    private static final String TAG = OsenseResClient.class.getSimpleName();

    public static OsenseResClient get(Class cls) {
        OsenseResClient osenseResClient;
        if (cls == null) {
            Log.e(TAG, "the parameter class is null!!!");
            return null;
        }
        String simpleName = cls.getSimpleName();
        synchronized (sOsenseResClientMap) {
            osenseResClient = sOsenseResClientMap.get(simpleName);
        }
        return osenseResClient;
    }
}
