package com.oplus.settings;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class OplusSettingsChangeListener extends ContentObserver {
    public abstract void onSettingsChange(boolean z, String str, int i);

    public OplusSettingsChangeListener(Handler handler) {
        super(handler);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        filterUserId(z, uri);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri, int i) {
        filterUserId(z, uri);
    }

    private void filterUserId(boolean z, Uri uri) {
        try {
            int intValue = Integer.valueOf(uri.getQueryParameter(OplusSettingsConfig.PARAMS_USER_ID)).intValue();
            if (OplusSettings.isSystemProcess()) {
                onSettingsChange(z, uri.getPath(), intValue);
            } else if (intValue != UserHandle.myUserId()) {
                Log.w("CSListener", "filterUserId else selfChange=" + z + " uri=" + uri.toString());
            } else {
                onSettingsChange(z, uri.getPath(), intValue);
            }
        } catch (Exception e) {
            Log.e("CSListener", "filterUserId ERROR selfChange=" + z + " uri=" + uri.toString(), e);
        }
    }
}
