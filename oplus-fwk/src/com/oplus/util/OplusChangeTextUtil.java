package com.oplus.util;

/* loaded from: classes.dex */
public class OplusChangeTextUtil {
    public static final int G1 = 1;
    public static final int G2 = 2;
    public static final int G3 = 3;
    public static final int G4 = 4;
    public static final int G5 = 5;
    public static final int G6 = 6;
    private static final float H1 = 0.9f;
    private static final float H2 = 1.0f;
    private static final float H3 = 1.1f;
    private static final float H4 = 1.25f;
    private static final float H5 = 1.45f;
    private static final float H6 = 1.65f;
    public static final float[] SCALE_LEVEL = {H1, H2, H3, H4, H5, H6};
    private static final String TAG = "OplusChangeTextUtil";

    public static float getSuitableFontSize(float f, float f2, int i) {
        if (i < 2) {
            return f;
        }
        float[] fArr = SCALE_LEVEL;
        if (i > fArr.length) {
            i = fArr.length;
        }
        float f3 = f / f2;
        switch (i) {
            case 2:
                if (f2 < H3) {
                    return f3 * H2;
                }
                return f3 * H3;
            case 3:
                if (f2 < H3) {
                    return f3 * H2;
                }
                if (f2 < H5) {
                    return f3 * H3;
                }
                return f3 * H4;
            default:
                float f4 = fArr[i - 1];
                if (f2 > f4) {
                    return f4 * f3;
                }
                return f3 * f2;
        }
    }
}
