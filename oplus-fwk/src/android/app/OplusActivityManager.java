package android.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.oplus.app.OplusAppInfo;
import java.util.List;

/* loaded from: classes.dex */
public class OplusActivityManager extends OplusBaseActivityManager implements IOplusActivityManager, IOplusActivityTaskManager {
    private static final String TAG = "OplusActivityManager";
    private final OplusActivityTaskManager mOplusAtm = OplusActivityTaskManager.getInstance();

    public static OplusActivityManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* loaded from: classes.dex */
    private static class LazyHolder {
        private static final OplusActivityManager INSTANCE = new OplusActivityManager();

        private LazyHolder() {
        }
    }

    public void swapDockedFullscreenStack() throws RemoteException {
    }

    @Override // android.app.IOplusActivityTaskManager
    public ComponentName getTopActivityComponentName() throws RemoteException {
        return this.mOplusAtm.getTopActivityComponentName();
    }

    @Override // android.app.IOplusActivityTaskManager
    public ApplicationInfo getTopApplicationInfo() throws RemoteException {
        return this.mOplusAtm.getTopApplicationInfo();
    }

    @Override // android.app.IOplusActivityTaskManager
    public List<OplusAppInfo> getAllTopAppInfos() throws RemoteException {
        return this.mOplusAtm.getAllTopAppInfos();
    }

    @Override // android.app.IOplusActivityTaskManager
    public List<OplusAppInfo> getAllTopApps() throws RemoteException {
        return this.mOplusAtm.getAllTopApps();
    }

    @Override // android.app.IOplusActivityManager
    public boolean putConfigInfo(String str, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken(IOplusBaseActivityManager.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeBundle(bundle);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                this.mRemote.transact(10062, obtain, obtain2, 0);
                obtain2.readException();
                return Boolean.valueOf(obtain2.readString()).booleanValue();
            } catch (Exception e) {
                Log.e(TAG, e.toString());
                obtain.recycle();
                obtain2.recycle();
                return true;
            }
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    @Override // android.app.IOplusActivityManager
    public Bundle getConfigInfo(String str, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        new Bundle();
        try {
            try {
                obtain.writeInterfaceToken(IOplusBaseActivityManager.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                this.mRemote.transact(10063, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readBundle();
            } catch (Exception e) {
                Log.e(TAG, e.toString());
                obtain.recycle();
                obtain2.recycle();
                return null;
            }
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
