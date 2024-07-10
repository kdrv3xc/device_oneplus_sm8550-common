package com.oplus.app;

import android.content.Context;

/* loaded from: classes.dex */
public class OplusAppSwitchManager {
    private static OplusAppSwitchManager sOplusAppSwitchManager = null;
    public static int APP_SWITCH_VERSION = 1;

    /* loaded from: classes.dex */
    public interface OnAppSwitchObserver {
        void onActivityEnter(OplusAppEnterInfo oplusAppEnterInfo);

        void onActivityExit(OplusAppExitInfo oplusAppExitInfo);

        void onAppEnter(OplusAppEnterInfo oplusAppEnterInfo);

        void onAppExit(OplusAppExitInfo oplusAppExitInfo);
    }

    public static OplusAppSwitchManager getInstance() {
        if (sOplusAppSwitchManager == null) {
            sOplusAppSwitchManager = new OplusAppSwitchManager();
        }
        return sOplusAppSwitchManager;
    }

    public boolean registerAppSwitchObserver(Context context, OnAppSwitchObserver onAppSwitchObserver, OplusAppSwitchConfig oplusAppSwitchConfig) {
        return true;
    }

    public boolean unregisterAppSwitchObserver(Context context, OnAppSwitchObserver onAppSwitchObserver) {
        return true;
    }
}
