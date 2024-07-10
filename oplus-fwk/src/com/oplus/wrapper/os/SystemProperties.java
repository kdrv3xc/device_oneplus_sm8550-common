package com.oplus.wrapper.os;

/* loaded from: classes.dex */
public class SystemProperties {
    public static String get(String str) {
        return android.os.SystemProperties.get(str);
    }

    public static String get(String str, String str2) {
        return android.os.SystemProperties.get(str, str2);
    }

    public static boolean getBoolean(String str, boolean z) {
        return android.os.SystemProperties.getBoolean(str, z);
    }

    public static int getInt(String str, int i) {
        return android.os.SystemProperties.getInt(str, i);
    }

    public static long getLong(String str, long j) {
        return android.os.SystemProperties.getLong(str, j);
    }

    public static void set(String str, String str2) {
        android.os.SystemProperties.set(str, str2);
    }
}
