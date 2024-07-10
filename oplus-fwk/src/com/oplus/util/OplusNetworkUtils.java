package com.oplus.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/* loaded from: classes.dex */
public class OplusNetworkUtils {
    private static final String DEFAULT_HTTP_URI = "http://connectivitycheck.gstatic.com/generate_204";

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) {
            return false;
        }
        return true;
    }

    public static boolean isMobileDataConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED;
    }

    public static void onClickLoginBtn(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(DEFAULT_HTTP_URI));
        intent.setFlags(272629760);
        context.startActivity(intent);
    }

    public static int getErrorString(Context context, String str) {
        return 1;
    }
}
