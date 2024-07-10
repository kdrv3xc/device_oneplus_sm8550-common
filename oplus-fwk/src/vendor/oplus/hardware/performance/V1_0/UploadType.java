package vendor.oplus.hardware.performance.V1_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class UploadType {
    public static final int DELTA = 1;
    public static final int PRIMITIVE = 0;
    public static final int SKIP = 2;

    public static final String toString(int i) {
        if (i == 0) {
            return "PRIMITIVE";
        }
        if (i == 1) {
            return "DELTA";
        }
        if (i == 2) {
            return "SKIP";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("PRIMITIVE");
        int i2 = 1;
        if ((i & 1) != 1) {
            i2 = 0;
        } else {
            arrayList.add("DELTA");
        }
        if ((i & 2) == 2) {
            arrayList.add("SKIP");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
