package com.oplus.orms;

import com.oplus.orms.info.OrmsSaParam;

/* loaded from: classes.dex */
public class OplusResourceManager {
    private static OplusResourceManager sOplusResourceManager = null;

    public static OplusResourceManager getInstance(Class cls) {
        if (sOplusResourceManager == null) {
            sOplusResourceManager = new OplusResourceManager();
        }
        return sOplusResourceManager;
    }

    public long ormsSetSceneAction(OrmsSaParam ormsSaParam) {
        return -1L;
    }
}
