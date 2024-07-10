package android.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.app.OplusAppInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OplusActivityTaskManager extends OplusBaseActivityTaskManager implements IOplusActivityTaskManager {
    public static OplusActivityTaskManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* loaded from: classes.dex */
    public static class LazyHolder {
        private static final OplusActivityTaskManager INSTANCE = new OplusActivityTaskManager();

        private LazyHolder() {
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public ComponentName getTopActivityComponentName() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IOplusBaseActivityTaskManager.DESCRIPTOR);
            this.mRemote.transact(10007, obtain, obtain2, 0);
            obtain2.readException();
            return ComponentName.readFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public ApplicationInfo getTopApplicationInfo() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IOplusBaseActivityTaskManager.DESCRIPTOR);
            this.mRemote.transact(10011, obtain, obtain2, 0);
            obtain2.readException();
            return (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public List<OplusAppInfo> getAllTopAppInfos() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        new ArrayList();
        try {
            obtain.writeInterfaceToken(IOplusBaseActivityTaskManager.DESCRIPTOR);
            this.mRemote.transact(10053, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(OplusAppInfo.CREATOR);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public List<OplusAppInfo> getAllTopApps() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        new ArrayList();
        try {
            obtain.writeInterfaceToken(IOplusBaseActivityTaskManager.DESCRIPTOR);
            this.mRemote.transact(10058, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(OplusAppInfo.CREATOR);
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
