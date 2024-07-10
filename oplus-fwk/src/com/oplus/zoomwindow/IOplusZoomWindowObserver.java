package com.oplus.zoomwindow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOplusZoomWindowObserver extends IInterface {
    public static final String DESCRIPTOR = "com.oplus.zoomwindow.IOplusZoomWindowObserver";

    void onInputMethodChanged(boolean z) throws RemoteException;

    void onZoomWindowDied(String str) throws RemoteException;

    void onZoomWindowHide(OplusZoomWindowInfo oplusZoomWindowInfo) throws RemoteException;

    void onZoomWindowShow(OplusZoomWindowInfo oplusZoomWindowInfo) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IOplusZoomWindowObserver {
        @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
        public void onInputMethodChanged(boolean z) throws RemoteException {
        }

        @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
        public void onZoomWindowDied(String str) throws RemoteException {
        }

        @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
        public void onZoomWindowHide(OplusZoomWindowInfo oplusZoomWindowInfo) throws RemoteException {
        }

        @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
        public void onZoomWindowShow(OplusZoomWindowInfo oplusZoomWindowInfo) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IOplusZoomWindowObserver {
        static final int TRANSACTION_onInputMethodChanged = 1;
        static final int TRANSACTION_onZoomWindowDied = 2;
        static final int TRANSACTION_onZoomWindowHide = 3;
        static final int TRANSACTION_onZoomWindowShow = 4;

        public Stub() {
            attachInterface(this, IOplusZoomWindowObserver.DESCRIPTOR);
        }

        public static IOplusZoomWindowObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOplusZoomWindowObserver.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOplusZoomWindowObserver)) {
                return (IOplusZoomWindowObserver) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOplusZoomWindowObserver.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOplusZoomWindowObserver.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    boolean readBoolean = parcel.readBoolean();
                    parcel.enforceNoDataAvail();
                    onInputMethodChanged(readBoolean);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    String readString = parcel.readString();
                    parcel.enforceNoDataAvail();
                    onZoomWindowDied(readString);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    OplusZoomWindowInfo oplusZoomWindowInfo = (OplusZoomWindowInfo) parcel.readTypedObject(OplusZoomWindowInfo.CREATOR);
                    parcel.enforceNoDataAvail();
                    onZoomWindowHide(oplusZoomWindowInfo);
                    parcel2.writeNoException();
                    parcel2.writeTypedObject(oplusZoomWindowInfo, 1);
                    return true;
                case 4:
                    OplusZoomWindowInfo oplusZoomWindowInfo2 = (OplusZoomWindowInfo) parcel.readTypedObject(OplusZoomWindowInfo.CREATOR);
                    parcel.enforceNoDataAvail();
                    onZoomWindowShow(oplusZoomWindowInfo2);
                    parcel2.writeNoException();
                    parcel2.writeTypedObject(oplusZoomWindowInfo2, 1);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IOplusZoomWindowObserver {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOplusZoomWindowObserver.DESCRIPTOR;
            }

            @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
            public void onInputMethodChanged(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain(asBinder());
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusZoomWindowObserver.DESCRIPTOR);
                    obtain.writeBoolean(z);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
            public void onZoomWindowDied(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain(asBinder());
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusZoomWindowObserver.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
            public void onZoomWindowHide(OplusZoomWindowInfo oplusZoomWindowInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain(asBinder());
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusZoomWindowObserver.DESCRIPTOR);
                    obtain.writeTypedObject(oplusZoomWindowInfo, 0);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        oplusZoomWindowInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.oplus.zoomwindow.IOplusZoomWindowObserver
            public void onZoomWindowShow(OplusZoomWindowInfo oplusZoomWindowInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain(asBinder());
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusZoomWindowObserver.DESCRIPTOR);
                    obtain.writeTypedObject(oplusZoomWindowInfo, 0);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        oplusZoomWindowInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
