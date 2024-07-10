package net.oneplus.odm;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public class OpDeviceManagerInjector {
    private static OpDeviceManagerInjector sOpDeviceManagerInjector = null;

    public void preserveAppData(Context context, String str, Map map, Map map2) {
    }

    public static OpDeviceManagerInjector getInstance() {
        if (sOpDeviceManagerInjector == null) {
            sOpDeviceManagerInjector = new OpDeviceManagerInjector();
        }
        return sOpDeviceManagerInjector;
    }
}
