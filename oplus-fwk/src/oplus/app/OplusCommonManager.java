package oplus.app;

import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class OplusCommonManager {
    protected final IBinder mRemote;

    public OplusCommonManager(String str) {
        this(ServiceManager.getService(str), str);
    }

    public OplusCommonManager(IBinder iBinder, String str) {
        if (iBinder == null) {
            Log.e("OplusCommonManager", "remote is null: " + str);
            iBinder = ServiceManager.getService(str);
            StringBuilder sb = new StringBuilder();
            sb.append("Retry remote is null: ");
            sb.append(iBinder == null);
            Log.d("OplusCommonManager", sb.toString());
        }
        this.mRemote = iBinder;
    }
}
