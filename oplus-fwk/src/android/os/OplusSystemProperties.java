package android.os;

/* loaded from: classes.dex */
public class OplusSystemProperties {
    public static String get(String str) {
        return SystemProperties.get(str, "");
    }

    public static String get(String str, String str2) {
        return SystemProperties.get(str, str2);
    }

    public static int getInt(String str, int i) {
        return SystemProperties.getInt(str, i);
    }

    public static boolean getBoolean(String str, boolean z) {
        return SystemProperties.getBoolean(str, z);
    }
}
