package com.oplus.settings;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class OplusSettings extends OplusBaseSettings {
    private static final String TAG = "OplusSettings";
    public static final int TYPE_OPLUS = 0;

    public static InputStream readConfig(Context context, String str, int i) throws IOException {
        return readConfigAsUser(context, str, -2, i);
    }

    public static OutputStream writeConfig(Context context, String str, int i) throws IOException {
        return writeConfigAsUser(context, str, -2, i);
    }

    public static String readConfigString(Context context, String str, int i) throws IOException {
        return readConfigStringAsUser(context, str, -2, i);
    }

    public static int writeConfigString(Context context, String str, int i, String str2) throws IOException {
        return writeConfigStringAsUser(context, str, -2, i, str2);
    }

    public static void registerChangeListener(Context context, String str, int i, OplusSettingsChangeListener oplusSettingsChangeListener) {
        registerChangeListenerAsUser(context, str, -2, i, oplusSettingsChangeListener);
    }

    public static void unRegisterChangeListener(Context context, OplusSettingsChangeListener oplusSettingsChangeListener) {
        context.getContentResolver().unregisterContentObserver(oplusSettingsChangeListener);
    }
}
