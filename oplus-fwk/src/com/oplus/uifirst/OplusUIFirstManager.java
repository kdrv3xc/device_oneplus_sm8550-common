package com.oplus.uifirst;

/* loaded from: classes.dex */
public class OplusUIFirstManager extends Utils {
    private static OplusUIFirstManager sInstance = null;

    private OplusUIFirstManager() {
    }

    public static OplusUIFirstManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusUIFirstManager();
        }
        return sInstance;
    }

    @Override // com.oplus.uifirst.Utils
    public void setUxThreadValue(int i, int i2, String str) {
    }
}
