package com.oplus.os;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.storage.DiskInfo;
import android.os.storage.IStorageManager;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OplusUsbEnvironment extends Environment {
    public static final int EXTERNAL = 2;
    public static final String FILE_SEPARATOR = "/";
    public static final int INTERNAL = 1;
    private static final String MULTIAPP_INTERNAL_PATH = "/storage/emulated/999";
    public static final int NONE = -1;
    public static final int OTG = 3;
    private static final String TAG = "OppoUsbEnvironmentSys";
    private static boolean sInited = false;
    private static final String DEFAULT_INTERNAL_PATH = "/storage/emulated/0";
    private static String sInternalSdDir = DEFAULT_INTERNAL_PATH;
    private static String sExternalSdDir = null;
    private static ArrayList<String> sOtgPathes = new ArrayList<>();
    private static IStorageManager sMountService = null;
    private static Object sLock = new Object();
    private static BroadcastReceiver sVolumeStateReceiver = new BroadcastReceiver() { // from class: com.oplus.os.OplusUsbEnvironment.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (OplusUsbEnvironment.sLock) {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("android.os.storage.extra.VOLUME_STATE", -1);
                String stringExtra = intent.getStringExtra("android.os.storage.extra.VOLUME_ID");
                if (intExtra == 2 || intExtra == 0) {
                    Log.d(OplusUsbEnvironment.TAG, "onReceive: action:" + action + ", state=" + intExtra + ", id=" + stringExtra);
                    OplusUsbEnvironment.getVolumes();
                }
            }
        }
    };
    private static StorageEventListener sStorageListener = new StorageEventListener() { // from class: com.oplus.os.OplusUsbEnvironment.2
        public void onVolumeStateChanged(VolumeInfo volumeInfo, int i, int i2) {
            synchronized (OplusUsbEnvironment.sLock) {
                DiskInfo disk = volumeInfo.getDisk();
                if (disk == null) {
                    return;
                }
                String str = volumeInfo.path;
                if (i != 2 && i2 == 2) {
                    if (disk.isSd() && str != null) {
                        OplusUsbEnvironment.sExternalSdDir = str;
                        Log.d(OplusUsbEnvironment.TAG, "onVolumeStateChanged: sd mount. sExternalSdDir=" + OplusUsbEnvironment.sExternalSdDir);
                    }
                    if (disk.isUsb() && str != null && !OplusUsbEnvironment.sOtgPathes.contains(str)) {
                        OplusUsbEnvironment.sOtgPathes.add(str);
                        Log.d(OplusUsbEnvironment.TAG, "onVolumeStateChanged: sOtgPathes.add=" + str);
                    }
                } else if (i2 != 2 && i == 2) {
                    if (disk.isSd()) {
                        OplusUsbEnvironment.sExternalSdDir = null;
                        Log.d(OplusUsbEnvironment.TAG, "onVolumeStateChanged: sd unmount. sExternalSdDir=" + OplusUsbEnvironment.sExternalSdDir);
                    }
                    if (disk.isUsb() && str != null && OplusUsbEnvironment.sOtgPathes.contains(str)) {
                        OplusUsbEnvironment.sOtgPathes.remove(str);
                        Log.d(OplusUsbEnvironment.TAG, "onVolumeStateChanged: sOtgPathes.remove=" + str);
                    }
                }
            }
        }
    };

    private static void update(Context context) {
        if (sMountService == null) {
            sMountService = IStorageManager.Stub.asInterface(ServiceManager.getService("mount"));
        }
        if (!sInited) {
            boolean z = true;
            sInited = true;
            getVolumes();
            Context applicationContext = context.getApplicationContext();
            if (context.checkSelfPermission("android.permission.WRITE_MEDIA_STORAGE") != 0) {
                z = false;
            }
            if (applicationContext == null || !z) {
                Log.d(TAG, "update: hasPerm WRITE_MEDIA_STORAGE=" + z + ", contextApp=" + applicationContext);
                StorageManager storageManager = (StorageManager) context.getSystemService("storage");
                if (storageManager != null) {
                    storageManager.registerListener(sStorageListener);
                    Log.d(TAG, "update: registerListener sStorageListener");
                    return;
                }
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.storage.action.VOLUME_STATE_CHANGED");
            applicationContext.registerReceiver(sVolumeStateReceiver, intentFilter);
            Log.d(TAG, "update: registerReceiver sVolumeStateReceiver");
        }
    }

    public static File getInternalSdDirectory(Context context) {
        String str;
        synchronized (sLock) {
            update(context);
            str = sInternalSdDir;
        }
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public static File getExternalSdDirectory(Context context) {
        String str;
        synchronized (sLock) {
            update(context);
            str = sExternalSdDir;
        }
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public static String getInternalSdState(Context context) {
        String str;
        StorageManager storageManager;
        synchronized (sLock) {
            update(context);
            str = sInternalSdDir;
        }
        if (str != null && (storageManager = (StorageManager) context.getSystemService("storage")) != null) {
            return storageManager.getVolumeState(str);
        }
        return "unknown";
    }

    public static String getExternalSdState(Context context) {
        String str;
        StorageManager storageManager;
        synchronized (sLock) {
            update(context);
            str = sExternalSdDir;
        }
        if (str != null && (storageManager = (StorageManager) context.getSystemService("storage")) != null) {
            return storageManager.getVolumeState(str);
        }
        return "unknown";
    }

    public static boolean isExternalSDRemoved(Context context) {
        String str;
        synchronized (sLock) {
            update(context);
            str = sExternalSdDir;
        }
        if (str == null) {
            return true;
        }
        String str2 = "unknown";
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            str2 = storageManager.getVolumeState(str);
        }
        Log.i(TAG, "isExternalSDRemoved: the state of volume is: " + str2);
        return "removed".equals(str2);
    }

    public static boolean isNestMounted() {
        boolean z;
        String str;
        synchronized (sLock) {
            String str2 = sInternalSdDir;
            if (str2 != null && (str = sExternalSdDir) != null && (str2.startsWith(str) || sExternalSdDir.startsWith(sInternalSdDir))) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static List<String> getOtgPath(Context context) {
        synchronized (sLock) {
            update(context);
            ArrayList<String> arrayList = sOtgPathes;
            if (arrayList == null) {
                return null;
            }
            return (ArrayList) arrayList.clone();
        }
    }

    public static boolean isVolumeMounted(Context context, String str) {
        synchronized (sLock) {
            update(context);
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (str != null && storageManager != null) {
            return "mounted".equals(storageManager.getVolumeState(str));
        }
        return false;
    }

    public static String getInternalPath(Context context) {
        String str;
        synchronized (sLock) {
            update(context);
            str = sInternalSdDir;
        }
        return str;
    }

    public static String getExternalPath(Context context) {
        String str;
        synchronized (sLock) {
            update(context);
            str = sExternalSdDir;
        }
        return str;
    }

    public static int getPathType(Context context, String str) {
        synchronized (sLock) {
            update(context);
            if (str == null) {
                return -1;
            }
            if (str.equals(sInternalSdDir)) {
                return 1;
            }
            if (str.equals(sExternalSdDir)) {
                return 2;
            }
            ArrayList<String> arrayList = sOtgPathes;
            if (arrayList != null && arrayList.contains(str)) {
                return 3;
            }
            return -1;
        }
    }

    public static void getVolumes() {
        IStorageManager iStorageManager = sMountService;
        if (iStorageManager == null) {
            Log.e(TAG, "getVolumes: sMountService is null!!!");
            return;
        }
        try {
            VolumeInfo[] volumes = iStorageManager.getVolumes(0);
            sExternalSdDir = null;
            sOtgPathes.clear();
            for (VolumeInfo volumeInfo : volumes) {
                String str = volumeInfo.path;
                if (volumeInfo.type == 2) {
                    int myUserId = UserHandle.myUserId();
                    if (str != null) {
                        sInternalSdDir = str.concat(FILE_SEPARATOR).concat(Integer.toString(myUserId));
                        Log.d(TAG, "getVolumes: sInternalSdDir=" + sInternalSdDir);
                    }
                } else {
                    DiskInfo disk = volumeInfo.getDisk();
                    if (disk != null) {
                        if (disk.isSd() && str != null) {
                            sExternalSdDir = str;
                            Log.d(TAG, "getVolumes: sExternalSdDir=" + sExternalSdDir);
                        }
                        if (disk.isUsb() && str != null && !sOtgPathes.contains(str)) {
                            sOtgPathes.add(str);
                            Log.d(TAG, "getVolumes: sOtgPathes.add=" + str);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
        }
    }

    public static String getMultiappSdDirectory() {
        return MULTIAPP_INTERNAL_PATH;
    }
}
