package com.oplus.wrapper.view;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IRotationWatcher {
    void onRotationChanged(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub implements IInterface, IRotationWatcher {
        private final android.view.IRotationWatcher mRotationWatcher;

        public Stub(android.view.IRotationWatcher iRotationWatcher) {
            this.mRotationWatcher = iRotationWatcher;
        }

        public static IRotationWatcher asInterface(IBinder iBinder) {
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.asInterface(android.os.IBinder):com.oplus.wrapper.view.IRotationWatcher");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.asBinder():android.os.IBinder");
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IRotationWatcher {
            private final android.view.IRotationWatcher mRotationWatcher;

            Proxy(android.view.IRotationWatcher iRotationWatcher) {
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.Proxy.<init>(android.view.IRotationWatcher):void");
            }

            @Override // com.oplus.wrapper.view.IRotationWatcher
            public void onRotationChanged(int i) throws RemoteException {
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.Proxy.onRotationChanged(int):void");
            }
        }
    }
}
