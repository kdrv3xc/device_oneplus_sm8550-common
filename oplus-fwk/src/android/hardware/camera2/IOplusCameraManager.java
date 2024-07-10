package android.hardware.camera2;

import android.common.IOplusCommonFeature;
import android.common.OplusFeatureList;
import android.content.Context;
import android.os.IBinder;

/* loaded from: classes.dex */
public interface IOplusCameraManager extends IOplusCommonFeature {
    public static final IOplusCameraManager DEFAULT = new IOplusCameraManager() { // from class: android.hardware.camera2.IOplusCameraManager.1
    };
    public static final String NAME = "IOplusCameraManager";

    /* loaded from: classes.dex */
    public enum Cmd {
        CMD_NONE,
        CMD_PRE_CAPTURE,
        CMD_PRE_OPEN,
        CMD_PRE_EVLIST,
        CMD_READ_MEM
    }

    @Override // android.common.IOplusCommonFeature
    default OplusFeatureList.OplusIndex index() {
        return OplusFeatureList.OplusIndex.IOplusCameraManager;
    }

    @Override // android.common.IOplusCommonFeature
    default IOplusCommonFeature getDefault() {
        return DEFAULT;
    }

    default void addAuthResultInfo(Context context, int i, int i2, int i3, String str) {
    }

    default void setDeathRecipient(IBinder iBinder) {
    }

    default boolean isAuthedClient(Context context) {
        return false;
    }

    default void preOpenCamera(Context context) {
    }

    default void sendOplusExtCamCmd(Context context, Cmd cmd, int[] iArr) {
    }

    default void setCallInfo() {
    }

    default void saveOpPackageName(String str) {
    }

    default void setPackageName() {
    }

    default boolean isPrivilegedApp(String str) {
        return false;
    }

    default boolean isCameraUnitSession() {
        return false;
    }

    default void parseSessionParameters(CaptureRequest captureRequest) {
    }
}
