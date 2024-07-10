package com.oplus.settings;

import android.net.Uri;
import android.os.UserHandle;
import java.io.File;

/* loaded from: classes.dex */
public final class OplusSettingsConfig {
    private static final String CONFIG_PATH = "/data/oplus";
    public static final String PARAMS_TYPE = "ParamsType";
    public static final String PARAMS_USER_ID = "ParamsUserId";
    private static final String TAG = "CSConfig";
    protected static final int TYPE_OPLUS = 0;

    private static String transferTypeToStr(int i) {
        switch (i) {
            case 0:
                return "os";
            default:
                throw new IllegalArgumentException("Error type=" + i);
        }
    }

    public static String getFilePath(int i, int i2, String str) {
        String transferTypeToStr = transferTypeToStr(i);
        if (i2 == 0) {
            return CONFIG_PATH + File.separator + transferTypeToStr + File.separator + str;
        }
        if (i2 == -2) {
            int myUserId = UserHandle.myUserId();
            return myUserId == 0 ? CONFIG_PATH + File.separator + transferTypeToStr + File.separator + str : CONFIG_PATH + File.separator + transferTypeToStr + File.separator + myUserId + File.separator + str;
        }
        if (i2 >= 0) {
            return CONFIG_PATH + File.separator + transferTypeToStr + File.separator + i2 + File.separator + str;
        }
        throw new IllegalArgumentException("Error userId=" + i2);
    }

    public static Uri getUri(String str, String str2, int i, int i2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(PARAMS_TYPE, String.valueOf(i2));
        if (i == -2) {
            i = UserHandle.myUserId();
        }
        buildUpon.appendQueryParameter(PARAMS_USER_ID, String.valueOf(i));
        buildUpon.encodedPath(str2);
        return buildUpon.build();
    }
}
