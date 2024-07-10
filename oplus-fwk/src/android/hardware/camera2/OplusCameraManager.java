package android.hardware.camera2;

import android.content.Context;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.IOplusCameraManager;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.media.Image;
import android.media.ImageReader;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class OplusCameraManager implements IOplusCameraManager {
    private static final String PERMISSION_SAFE_CAMERA = "com.oplus.permission.safe.CAMERA";
    public static final int READ_CAMERA_SERVER_MEMORY_INFO = 1;
    public static final int READ_HAL_MEMORY_INFO = 0;
    private static final String TAG = "OplusCameraManager";
    private static final String SYSTEM_CAMERA_PACKNAME = SystemProperties.get("ro.oplus.system.camera.name");
    private static final CaptureRequest.Key<byte[]> KEY_OPLUS_PACKAGE = new CaptureRequest.Key<>("com.oplus.is.sdk.camera.package", byte[].class);
    private static OplusCameraManager mInstance = new OplusCameraManager();
    private static String[] SET_PACKAGE_BLACK_LIST = {"com.oplus.battery", "com.oplus.onetrace", "com.android.systemui", "com.oplus.obrain"};
    private String mOpPackageName = "";
    private boolean mIsCameraUnitSession = false;
    private boolean mbLoad = false;

    public native int nativeSendToAttachHWBufToBufQEvent(long j);

    public native int nativeSendToBufQAllocEnableEvent(long j);

    public native int nativeSendToExchgHWBufBtwBufQEvent(long j);

    public native void nativtSendToProcessHeif(long j);

    private OplusCameraManager() {
    }

    private void checkLoadLibrary() {
        Log.i(TAG, "checkLoadHeifLibbrary, mbLoad: " + this.mbLoad);
        if (this.mbLoad) {
            return;
        }
        try {
            System.loadLibrary("HeifWinBufExchg-jni");
            this.mbLoad = true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "checkLoadHeifLibbrary, error");
        }
    }

    public void sendToProcessHeif(long j) {
        checkLoadLibrary();
        nativtSendToProcessHeif(j);
    }

    public int sendToBufQAllocEnableEvent(long j) {
        checkLoadLibrary();
        return nativeSendToBufQAllocEnableEvent(j);
    }

    public int sendToExchgHWBufBtwBufQEvent(long j) {
        checkLoadLibrary();
        return nativeSendToExchgHWBufBtwBufQEvent(j);
    }

    public int sendToAttachHWBufToBufQEvent(long j) {
        checkLoadLibrary();
        return nativeSendToAttachHWBufToBufQEvent(j);
    }

    public static synchronized OplusCameraManager getInstance() {
        OplusCameraManager oplusCameraManager;
            synchronized (OplusCameraManager.class) {
                oplusCameraManager = mInstance;
            }
            return oplusCameraManager;
    }

    public static Object getEmptyCameraMetadataNative(long[] jArr) {
        CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
        if (jArr != null && jArr.length > 0) {
            jArr[0] = cameraMetadataNative.getMetadataPtr();
        }
        return cameraMetadataNative;
    }

    public static TotalCaptureResult generateTotalCaptureResult(Object obj, long j) {
        if (obj == null || !(obj instanceof CameraMetadataNative)) {
            return null;
        }
        TotalCaptureResult totalCaptureResult = new TotalCaptureResult((CameraMetadataNative) obj, 0);
        try {
            Field declaredField = CaptureResult.class.getDeclaredField("mFrameNumber");
            declaredField.setAccessible(true);
            declaredField.setLong(totalCaptureResult, j);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return totalCaptureResult;
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void addAuthResultInfo(Context context, int i, int i2, int i3, String str) {
        context.enforceCallingOrSelfPermission(PERMISSION_SAFE_CAMERA, TAG);
        if (i == 0) {
            throw new IllegalArgumentException("uid was 0, which is illegal.");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("pid was 0, which is illegal.");
        }
        if (str == null) {
            throw new IllegalArgumentException("packageName was null, which is illegal.");
        }
        try {
            OplusCameraManagerGlobal.get().addAuthResultInfo(i, i2, i3, str);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void setDeathRecipient(IBinder iBinder) {
        if (iBinder == null) {
            throw new IllegalArgumentException("client was null");
        }
        try {
            OplusCameraManagerGlobal.get().setDeathRecipient(iBinder);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public boolean isAuthedClient(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context was null");
        }
        try {
            return OplusCameraManagerGlobal.get().isAuthedClient(context.getOpPackageName());
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void preOpenCamera(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context was null");
        }
        context.enforceCallingOrSelfPermission(PERMISSION_SAFE_CAMERA, TAG);
        try {
            OplusCameraManagerGlobal.get().preOpenCamera(context.getOpPackageName());
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void sendOplusExtCamCmd(Context context, IOplusCameraManager.Cmd cmd, int[] iArr) {
        if (context == null) {
            throw new IllegalArgumentException("context was null");
        }
        context.enforceCallingOrSelfPermission(PERMISSION_SAFE_CAMERA, TAG);
        try {
            OplusCameraManagerGlobal.get().sendOplusExtCamCmd(context.getOpPackageName(), cmd, iArr);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void readMemoryInfo(IOplusCameraManager.Cmd cmd, StringBuilder sb, int i) {
        try {
            OplusCameraManagerGlobal.get().readMemoryInfo(cmd, sb, i);
        } catch (CameraAccessException e) {
            Log.e(TAG, "readOplusMemory, CameraAccessException: " + e);
        } catch (RemoteException e2) {
            Log.e(TAG, "readOplusMemory, RemoteException: " + e2);
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void setCallInfo() {
        try {
            OplusCameraManagerGlobal.get().setCallInfo();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void saveOpPackageName(String str) {
        this.mOpPackageName = str;
        Log.i(TAG, "saveOpPackageName, mOpPackageName: " + this.mOpPackageName);
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void setPackageName() {
        for (String str : SET_PACKAGE_BLACK_LIST) {
            if (str.equals(this.mOpPackageName)) {
                return;
            }
        }
        try {
            OplusCameraManagerGlobal.get().setClientInfo(this.mOpPackageName, Binder.getCallingUid(), Binder.getCallingPid());
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void setRIOClientInfo() throws CameraAccessException {
        Log.i(TAG, "uid = " + Binder.getCallingUid() + ", pid = " + Binder.getCallingPid());
        try {
            OplusCameraManagerGlobal.get().setRIOClientInfo(Binder.getCallingUid(), Binder.getCallingPid());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public boolean isPrivilegedApp(String str) {
        String str2;
        if (str == null || (str2 = SYSTEM_CAMERA_PACKNAME) == null || !str2.equals(str)) {
            return false;
        }
        return true;
    }

    public void setTorchIntensity(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("torchIntensity was less than 0, which is illegal.");
        }
        try {
            OplusCameraManagerGlobal.get().setTorchIntensity(i);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void disconnectClients() {
        try {
            OplusCameraManagerGlobal.get().disconnectClients();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public boolean isClientConnected() {
        try {
            return OplusCameraManagerGlobal.get().isClientConnected();
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public boolean isCameraUnitSession() {
        return this.mIsCameraUnitSession;
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void parseSessionParameters(CaptureRequest captureRequest) {
        if (captureRequest == null) {
            setIsCameraUnitSession(false);
            return;
        }
        byte[] bArr = (byte[]) captureRequest.get(KEY_OPLUS_PACKAGE);
        if (bArr == null || bArr.length == 0) {
            setIsCameraUnitSession(false);
            return;
        }
        if (1 == bArr[0]) {
            setIsCameraUnitSession(true);
        }
        Log.i(TAG, "parseSessionParameters mIsCameraUnitSession: " + this.mIsCameraUnitSession);
    }

    public void oplusDetachImage(Image image, ImageReader imageReader) {
        try {
            Method declaredMethod = ImageReader.class.getDeclaredMethod("detachImage", Image.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(imageReader, image);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "using reflection to visit detachImage method in ImageReader");
    }

    public static void setOmojiJson(String str) {
        Log.i(TAG, "setOmojiJson called.");
        if (str == null || "".equals(str)) {
            Log.i(TAG, "jsonInfo is null");
            return;
        }
        try {
            OplusCameraManagerGlobal.get().setOmojiJson(str);
        } catch (CameraAccessException e) {
            Log.i(TAG, "setOmojiJson :" + e.getMessage());
        } catch (RemoteException e2) {
            Log.i(TAG, "setOmojiJson :" + e2.getMessage());
        }
    }

    public void closeAON() throws CameraAccessException {
        Log.i(TAG, "uid = " + Binder.getCallingUid() + ", pid = " + Binder.getCallingPid());
        try {
            OplusCameraManagerGlobal.get().closeAON();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void setIsCameraUnitSession(boolean z) {
        this.mIsCameraUnitSession = z;
        try {
            OplusCameraManagerGlobal.get().setIsCameraUnitSession(this.mIsCameraUnitSession);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    public static final class OplusCameraManagerGlobal implements IBinder.DeathRecipient {
        private static final int ADD_AUTH_RESULT = 10001;
        private static final String CAMERA_SERVICE_BINDER_NAME = "media.camera";
        private static final int CLIENT_IS_AUTHED = 10004;
        private static final int CLOSE_AON = 10013;
        private static final int CONNECT_STATUS = 10011;
        private static final String DESCRIPTOR = "android.hardware.camera";
        private static final int DISCONNECT_CLIENTS = 10009;
        private static final int OPEN_AON = 10012;
        private static final int OPLUS_CAMERA_FIRST_CALL_TRANSACTION = 10000;
        private static final int PRE_OPEN_CAMERA = 10014;
        private static final int READ_OPLUS_CAMERA_SERVER_MEMORY = 10018;
        private static final int READ_OPLUS_HAL_MEMORY = 10017;
        private static final int SEND_OPLUS_EXT_CAM_CMD = 10015;
        private static final int SET_CALL_INFO = 10006;
        private static final int SET_CLIENT_INFO = 10005;
        private static final int SET_DEATH_RECIPIENT = 10002;
        private static final int SET_IS_CAMERA_UNIT_SESSION = 10016;
        private static final int SET_OMOJI_JSON = 10010;
        private static final int SET_PACKAGE_NAME = 10003;
        private static final int SET_RIO_CLIENT_INFO = 10007;
        private static final int SET_TORCH_INTENSITY = 10008;
        private static final String TAG = "OplusCameraManagerGlobal";
        private static final OplusCameraManagerGlobal gCameraManager = new OplusCameraManagerGlobal();
        public static final boolean sCameraServiceDisabled = SystemProperties.getBoolean("config.disable_cameraservice", false);
        private final boolean DEBUG = false;
        private final Object mLock = new Object();
        private IBinder mRemote = null;

        private OplusCameraManagerGlobal() {
        }

        public static OplusCameraManagerGlobal get() {
            return gCameraManager;
        }

        private void connectCameraServiceLocked() {
            if (this.mRemote != null || sCameraServiceDisabled) {
                return;
            }
            Log.i(TAG, "Connecting to camera service");
            IBinder service = ServiceManager.getService(CAMERA_SERVICE_BINDER_NAME);
            this.mRemote = service;
            if (service == null) {
                return;
            }
            try {
                service.linkToDeath(this, 0);
            } catch (RemoteException e) {
            }
        }

        public IBinder getCameraServiceRemote() {
            IBinder iBinder;
            synchronized (this.mLock) {
                connectCameraServiceLocked();
                if (this.mRemote == null && !sCameraServiceDisabled) {
                    Log.e(TAG, "Camera service is unavailable");
                }
                iBinder = this.mRemote;
            }
            return iBinder;
        }

        public void addAuthResultInfo(int i, int i2, int i3, String str) throws CameraAccessException, RemoteException {
            Log.e(TAG, "addAuthResultInfo");
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeInt(i3);
                obtain.writeString(str);
                this.mRemote.transact(10001, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public void setDeathRecipient(IBinder iBinder) throws CameraAccessException, RemoteException {
            Log.e(TAG, "setDeathRecipient");
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeStrongBinder(iBinder);
                this.mRemote.transact(SET_DEATH_RECIPIENT, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        /* JADX WARN: Finally extract failed */
        public boolean isAuthedClient(String str) throws CameraAccessException, RemoteException {
            Log.e(TAG, "isAuthedClient, need check packageName: " + str);
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(CLIENT_IS_AUTHED, obtain, obtain2, 0);
                obtain2.readException();
                boolean readBoolean = obtain2.readBoolean();
                obtain.recycle();
                obtain2.recycle();
                Log.e(TAG, "isAuthedClient, the " + str + " is Authed " + readBoolean);
                return readBoolean;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        /* JADX WARN: Finally extract failed */
        public void preOpenCamera(String str) throws CameraAccessException, RemoteException {
            Log.e(TAG, "preOpenCamera, need check packageName: " + str);
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeInt(1);
                this.mRemote.transact(PRE_OPEN_CAMERA, obtain, obtain2, 0);
                obtain2.readException();
                obtain.recycle();
                obtain2.recycle();
                Log.e(TAG, "preOpenCamera, the " + str + " preOpenSend ");
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        /* JADX WARN: Finally extract failed */
        public void sendOplusExtCamCmd(String str, IOplusCameraManager.Cmd cmd, int[] iArr) throws CameraAccessException, RemoteException {
            Log.e(TAG, "sendOplusExtCamCmd, packageName: " + str + ", cmd: " + cmd);
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeInt(cmd.ordinal());
                obtain.writeIntArray(iArr);
                this.mRemote.transact(SEND_OPLUS_EXT_CAM_CMD, obtain, obtain2, 1);
                obtain2.readException();
                obtain.recycle();
                obtain2.recycle();
                Log.e(TAG, "sendOplusExtCamCmd complete ");
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        /* JADX WARN: Finally extract failed */
        public void readMemoryInfo(IOplusCameraManager.Cmd cmd, StringBuilder sb, int i) throws CameraAccessException, RemoteException {
            Log.i(TAG, "readMemoryInfo, cmd: " + cmd);
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(cmd.ordinal());
                this.mRemote.transact(i == 0 ? READ_OPLUS_HAL_MEMORY : READ_OPLUS_CAMERA_SERVER_MEMORY, obtain, obtain2, 0);
                sb.append(new String(obtain2.createByteArray()));
                obtain.recycle();
                obtain2.recycle();
                Log.i(TAG, "readMemoryInfo complete");
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        public void setCallInfo() throws CameraAccessException, RemoteException {
            Log.e(TAG, "setCallInfo");
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                this.mRemote.transact(SET_CALL_INFO, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public void setPackageName(String str) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setPackageName");
            IBinder cameraServiceRemote = getCameraServiceRemote();
            if (cameraServiceRemote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeString(str);
                cameraServiceRemote.transact(SET_PACKAGE_NAME, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public void setClientInfo(String str, int i, int i2) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setClientInfo, packageName: " + str + ", uid: " + i + ", pid: " + i2);
            IBinder cameraServiceRemote = getCameraServiceRemote();
            if (cameraServiceRemote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                cameraServiceRemote.transact(SET_CLIENT_INFO, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public void setRIOClientInfo(int i, int i2) throws CameraAccessException, RemoteException {
            Log.i(TAG, "uid: " + i + ", pid: " + i2);
            IBinder cameraServiceRemote = getCameraServiceRemote();
            if (cameraServiceRemote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                cameraServiceRemote.transact(SET_RIO_CLIENT_INFO, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        /* JADX WARN: Finally extract failed */
        public void setOmojiJson(String str) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setOmojiJson E");
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeString(str);
                Log.i(TAG, "setOmojiJson process E");
                this.mRemote.transact(SET_OMOJI_JSON, obtain, obtain2, 0);
                Log.i(TAG, "setOmojiJson process X");
                obtain2.readException();
                obtain.recycle();
                obtain2.recycle();
                Log.i(TAG, "setOmojiJson X");
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        public void setTorchIntensity(int i) throws CameraAccessException, RemoteException {
            Log.d(TAG, "setTorchIntensity: " + i);
            IBinder cameraServiceRemote = getCameraServiceRemote();
            if (cameraServiceRemote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeInt(i);
                cameraServiceRemote.transact(SET_TORCH_INTENSITY, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public void disconnectClients() throws CameraAccessException, RemoteException {
            Log.e(TAG, "disconnectClients");
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                this.mRemote.transact(DISCONNECT_CLIENTS, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        /* JADX WARN: Finally extract failed */
        public boolean isClientConnected() throws CameraAccessException, RemoteException {
            Log.e(TAG, "isClientConnected");
            if (getCameraServiceRemote() == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                this.mRemote.transact(CONNECT_STATUS, obtain, obtain2, 0);
                obtain2.readException();
                boolean readBoolean = obtain2.readBoolean();
                obtain.recycle();
                obtain2.recycle();
                Log.e(TAG, "isClientConnected: " + readBoolean);
                return readBoolean;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        public void closeAON() throws CameraAccessException, RemoteException {
            Log.i(TAG, "closeAON E");
            IBinder cameraServiceRemote = getCameraServiceRemote();
            if (cameraServiceRemote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                cameraServiceRemote.transact(CLOSE_AON, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        public void setIsCameraUnitSession(boolean z) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setIsCameraUnitSession E");
            IBinder cameraServiceRemote = getCameraServiceRemote();
            if (cameraServiceRemote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(DESCRIPTOR);
                obtain.writeBoolean(z);
                cameraServiceRemote.transact(SET_IS_CAMERA_UNIT_SESSION, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mRemote = null;
        }
    }
}
