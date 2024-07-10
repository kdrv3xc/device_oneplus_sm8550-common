package android.content.pm;

import android.content.IntentSender;
import android.content.pm.IPackageDeleteObserver;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.UserHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IOplusPackageManager extends IInterface {
    public static final String DESCRIPTOR = "android.content.pm.IOplusPackageManager";

    Bundle appDetailsForwardToMarket(int i, Bundle bundle) throws RemoteException;

    void deletePackageDelegated(String str, int i, int i2, int i3, int i4, IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException;

    boolean disableFeature(String str) throws RemoteException;

    boolean disableFeatureMap(String str, int i) throws RemoteException;

    boolean enableFeature(String str) throws RemoteException;

    boolean enableFeatureMap(String str, int i) throws RemoteException;

    boolean fixupAppData(String str, String str2, int i) throws RemoteException;

    int getAbiCheckResult(String str) throws RemoteException;

    Map getActivityIconsCache(IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException;

    Bitmap getAppIconBitmap(String str) throws RemoteException;

    Map getAppIconsCache(boolean z) throws RemoteException;

    List<String> getAppListFromPartition(String str) throws RemoteException;

    List<String> getCptListByType(int i) throws RemoteException;

    String getCustomizeDefaultApp(String str) throws RemoteException;

    List<String> getDetectAppList() throws RemoteException;

    List<String> getFreezedApplicationList(UserHandle userHandle) throws RemoteException;

    List<ApplicationInfo> getIconPackList() throws RemoteException;

    String getMigMappingPkgName(boolean z, String str) throws RemoteException;

    List<String> getNotInstalledSystemApps() throws RemoteException;

    int getOplusFreezePackageState(String str, int i) throws RemoteException;

    List<String> getOplusFreezedPackageList(int i) throws RemoteException;

    int getOplusPackageFreezeFlag(String str, int i) throws RemoteException;

    FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException;

    int getPackageFreezeState(String str, UserHandle userHandle) throws RemoteException;

    int getPackageFreezeUserSetting(String str, UserHandle userHandle) throws RemoteException;

    List<String> getRemovableAppList() throws RemoteException;

    List<String> getUninstallableAppConfig(int i) throws RemoteException;

    List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) throws RemoteException;

    List<String> getValidAppList() throws RemoteException;

    boolean hasFeatureIPC(String str, int i) throws RemoteException;

    boolean inCptWhiteList(int i, String str) throws RemoteException;

    boolean inOplusFreezePackageList(String str, int i) throws RemoteException;

    boolean inOplusStandardWhiteList(String str, int i, String str2) throws RemoteException;

    boolean inPmsWhiteList(int i, String str, List<String> list) throws RemoteException;

    boolean inUninstallableAppConfig(int i, String str) throws RemoteException;

    boolean isClosedSuperFirewall() throws RemoteException;

    boolean isCrossVersionUpdate() throws RemoteException;

    boolean isDetectApp(String str) throws RemoteException;

    boolean isFreezeEnabled() throws RemoteException;

    boolean isSecurePayApp(String str) throws RemoteException;

    boolean isSupportSessionWrite() throws RemoteException;

    boolean isSystemDataApp(String str) throws RemoteException;

    boolean markResolveIntentForMarket(String str) throws RemoteException;

    void notifyFeaturesMapUpdate(String str, String str2, int i) throws RemoteException;

    void notifyFeaturesUpdate(String str, String str2) throws RemoteException;

    int oplusFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException;

    int oplusUnFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException;

    boolean prohibitChildInstallation(int i, boolean z) throws RemoteException;

    List<String> queryIncompatibleApplist() throws RemoteException;

    void removeCustomizeDefaultApp(String str) throws RemoteException;

    boolean restoreRemovableApp(String str, IntentSender intentSender, Bundle bundle) throws RemoteException;

    void sendMapCommonDcsUpload(String str, String str2, Map map) throws RemoteException;

    boolean setCustomizeDefaultApp(String str, String str2) throws RemoteException;

    void setFreezeEnable(boolean z) throws RemoteException;

    void setPackageFreezeState(String str, int i, UserHandle userHandle) throws RemoteException;

    void setPackageFreezeUserSetting(String str, int i, UserHandle userHandle) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IOplusPackageManager {
        @Override // android.content.pm.IOplusPackageManager
        public boolean isClosedSuperFirewall() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public Bitmap getAppIconBitmap(String str) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public Map getAppIconsCache(boolean z) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public Map getActivityIconsCache(IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean prohibitChildInstallation(int i, boolean z) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int oplusFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int oplusUnFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getOplusFreezePackageState(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inOplusFreezePackageList(String str, int i) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getOplusFreezedPackageList(int i) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getOplusPackageFreezeFlag(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isSecurePayApp(String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isSystemDataApp(String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inPmsWhiteList(int i, String str, List<String> list) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getRemovableAppList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean restoreRemovableApp(String str, IntentSender intentSender, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isSupportSessionWrite() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getCptListByType(int i) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inCptWhiteList(int i, String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inOplusStandardWhiteList(String str, int i, String str2) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void sendMapCommonDcsUpload(String str, String str2, Map map) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<ApplicationInfo> getIconPackList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isDetectApp(String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getDetectAppList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isCrossVersionUpdate() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getNotInstalledSystemApps() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getValidAppList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getAppListFromPartition(String str) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void deletePackageDelegated(String str, int i, int i2, int i3, int i4, IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean setCustomizeDefaultApp(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void removeCustomizeDefaultApp(String str) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public String getCustomizeDefaultApp(String str) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean fixupAppData(String str, String str2, int i) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public String getMigMappingPkgName(boolean z, String str) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getUninstallableAppConfig(int i) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inUninstallableAppConfig(int i, String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isFreezeEnabled() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void setFreezeEnable(boolean z) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getPackageFreezeState(String str, UserHandle userHandle) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getPackageFreezeUserSetting(String str, UserHandle userHandle) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void setPackageFreezeState(String str, int i, UserHandle userHandle) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public void setPackageFreezeUserSetting(String str, int i, UserHandle userHandle) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getFreezedApplicationList(UserHandle userHandle) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean hasFeatureIPC(String str, int i) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean enableFeature(String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean disableFeature(String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean enableFeatureMap(String str, int i) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean disableFeatureMap(String str, int i) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void notifyFeaturesUpdate(String str, String str2) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public void notifyFeaturesMapUpdate(String str, String str2, int i) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public Bundle appDetailsForwardToMarket(int i, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean markResolveIntentForMarket(String str) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getAbiCheckResult(String str) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> queryIncompatibleApplist() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IOplusPackageManager {
        static final int TRANSACTION_appDetailsForwardToMarket = 66;
        static final int TRANSACTION_deletePackageDelegated = 36;
        static final int TRANSACTION_disableFeature = 55;
        static final int TRANSACTION_disableFeatureMap = 57;
        static final int TRANSACTION_dynamicDetectApp = 29;
        static final int TRANSACTION_enableFeature = 54;
        static final int TRANSACTION_enableFeatureMap = 56;
        static final int TRANSACTION_fixupAppData = 41;
        static final int TRANSACTION_getAbiCheckResult = 68;
        static final int TRANSACTION_getActivityIconsCache = 4;
        static final int TRANSACTION_getAppIconBitmap = 2;
        static final int TRANSACTION_getAppIconsCache = 3;
        static final int TRANSACTION_getAppListFromPartition = 35;
        static final int TRANSACTION_getCptListByType = 24;
        static final int TRANSACTION_getCustomizeDefaultApp = 40;
        static final int TRANSACTION_getDetectAppList = 31;
        static final int TRANSACTION_getFreezedApplicationList = 51;
        static final int TRANSACTION_getIconPackList = 28;
        static final int TRANSACTION_getInterceptRuleInfos = 17;
        static final int TRANSACTION_getMigMappingPkgName = 42;
        static final int TRANSACTION_getNotInstalledSystemApps = 33;
        static final int TRANSACTION_getOplusFreezePackageState = 8;
        static final int TRANSACTION_getOplusFreezedPackageList = 10;
        static final int TRANSACTION_getOplusPackageFreezeFlag = 11;
        static final int TRANSACTION_getOplusSystemAvailableFeatures = 12;
        static final int TRANSACTION_getPackageFreezeState = 47;
        static final int TRANSACTION_getPackageFreezeUserSetting = 48;
        static final int TRANSACTION_getRemovableAppInfo = 21;
        static final int TRANSACTION_getRemovableAppInfos = 20;
        static final int TRANSACTION_getRemovableAppList = 18;
        static final int TRANSACTION_getRemovedAppInfos = 19;
        static final int TRANSACTION_getSystemUpdateInfo = 37;
        static final int TRANSACTION_getUninstallableAppConfig = 43;
        static final int TRANSACTION_getUserSettingFreezeableApplicationList = 52;
        static final int TRANSACTION_getValidAppList = 34;
        static final int TRANSACTION_hasFeatureIPC = 53;
        static final int TRANSACTION_inCptWhiteList = 25;
        static final int TRANSACTION_inOplusFreezePackageList = 9;
        static final int TRANSACTION_inOplusStandardWhiteList = 26;
        static final int TRANSACTION_inPmsWhiteList = 15;
        static final int TRANSACTION_inUninstallableAppConfig = 44;
        static final int TRANSACTION_isClosedSuperFirewall = 1;
        static final int TRANSACTION_isCrossVersionUpdate = 32;
        static final int TRANSACTION_isDetectApp = 30;
        static final int TRANSACTION_isFreezeEnabled = 45;
        static final int TRANSACTION_isSecurePayApp = 13;
        static final int TRANSACTION_isSupportSessionWrite = 23;
        static final int TRANSACTION_isSystemDataApp = 14;
        static final int TRANSACTION_markResolveIntentForMarket = 67;
        static final int TRANSACTION_notifyFeaturesMapUpdate = 59;
        static final int TRANSACTION_notifyFeaturesUpdate = 58;
        static final int TRANSACTION_oplusFreezePackage = 6;
        static final int TRANSACTION_oplusUnFreezePackage = 7;
        static final int TRANSACTION_prohibitChildInstallation = 5;
        static final int TRANSACTION_queryIncompatibleApplist = 69;
        static final int TRANSACTION_registerFeatureActionObserverInner = 64;
        static final int TRANSACTION_registerFeatureMapObserverInner = 62;
        static final int TRANSACTION_registerFeatureObserverInner = 60;
        static final int TRANSACTION_removeCustomizeDefaultApp = 39;
        static final int TRANSACTION_restoreRemovableApp = 22;
        static final int TRANSACTION_sendMapCommonDcsUpload = 27;
        static final int TRANSACTION_setCustomizeDefaultApp = 38;
        static final int TRANSACTION_setFreezeEnable = 46;
        static final int TRANSACTION_setInterceptRuleInfos = 16;
        static final int TRANSACTION_setPackageFreezeState = 49;
        static final int TRANSACTION_setPackageFreezeUserSetting = 50;
        static final int TRANSACTION_unregisterFeatureActionObserverInner = 65;
        static final int TRANSACTION_unregisterFeatureMapObserverInner = 63;
        static final int TRANSACTION_unregisterFeatureObserverInner = 61;

        public Stub() {
            attachInterface(this, IOplusPackageManager.DESCRIPTOR);
        }

        public static IOplusPackageManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOplusPackageManager.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOplusPackageManager)) {
                return (IOplusPackageManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int i) {
            switch (i) {
                case 1:
                    return "isClosedSuperFirewall";
                case 2:
                    return "getAppIconBitmap";
                case 3:
                    return "getAppIconsCache";
                case 4:
                    return "getActivityIconsCache";
                case 5:
                    return "prohibitChildInstallation";
                case 6:
                    return "oplusFreezePackage";
                case 7:
                    return "oplusUnFreezePackage";
                case 8:
                    return "getOplusFreezePackageState";
                case 9:
                    return "inOplusFreezePackageList";
                case 10:
                    return "getOplusFreezedPackageList";
                case 11:
                    return "getOplusPackageFreezeFlag";
                case 12:
                    return "getOplusSystemAvailableFeatures";
                case 13:
                    return "isSecurePayApp";
                case 14:
                    return "isSystemDataApp";
                case 15:
                    return "inPmsWhiteList";
                case 16:
                    return "setInterceptRuleInfos";
                case 17:
                    return "getInterceptRuleInfos";
                case 18:
                    return "getRemovableAppList";
                case 19:
                    return "getRemovedAppInfos";
                case 20:
                    return "getRemovableAppInfos";
                case 21:
                    return "getRemovableAppInfo";
                case 22:
                    return "restoreRemovableApp";
                case 23:
                    return "isSupportSessionWrite";
                case 24:
                    return "getCptListByType";
                case 25:
                    return "inCptWhiteList";
                case TRANSACTION_inOplusStandardWhiteList /* 26 */:
                    return "inOplusStandardWhiteList";
                case TRANSACTION_sendMapCommonDcsUpload /* 27 */:
                    return "sendMapCommonDcsUpload";
                case TRANSACTION_getIconPackList /* 28 */:
                    return "getIconPackList";
                case TRANSACTION_dynamicDetectApp /* 29 */:
                    return "dynamicDetectApp";
                case TRANSACTION_isDetectApp /* 30 */:
                    return "isDetectApp";
                case TRANSACTION_getDetectAppList /* 31 */:
                    return "getDetectAppList";
                case 32:
                    return "isCrossVersionUpdate";
                case TRANSACTION_getNotInstalledSystemApps /* 33 */:
                    return "getNotInstalledSystemApps";
                case TRANSACTION_getValidAppList /* 34 */:
                    return "getValidAppList";
                case TRANSACTION_getAppListFromPartition /* 35 */:
                    return "getAppListFromPartition";
                case TRANSACTION_deletePackageDelegated /* 36 */:
                    return "deletePackageDelegated";
                case TRANSACTION_getSystemUpdateInfo /* 37 */:
                    return "getSystemUpdateInfo";
                case TRANSACTION_setCustomizeDefaultApp /* 38 */:
                    return "setCustomizeDefaultApp";
                case TRANSACTION_removeCustomizeDefaultApp /* 39 */:
                    return "removeCustomizeDefaultApp";
                case TRANSACTION_getCustomizeDefaultApp /* 40 */:
                    return "getCustomizeDefaultApp";
                case TRANSACTION_fixupAppData /* 41 */:
                    return "fixupAppData";
                case TRANSACTION_getMigMappingPkgName /* 42 */:
                    return "getMigMappingPkgName";
                case TRANSACTION_getUninstallableAppConfig /* 43 */:
                    return "getUninstallableAppConfig";
                case TRANSACTION_inUninstallableAppConfig /* 44 */:
                    return "inUninstallableAppConfig";
                case TRANSACTION_isFreezeEnabled /* 45 */:
                    return "isFreezeEnabled";
                case TRANSACTION_setFreezeEnable /* 46 */:
                    return "setFreezeEnable";
                case TRANSACTION_getPackageFreezeState /* 47 */:
                    return "getPackageFreezeState";
                case TRANSACTION_getPackageFreezeUserSetting /* 48 */:
                    return "getPackageFreezeUserSetting";
                case TRANSACTION_setPackageFreezeState /* 49 */:
                    return "setPackageFreezeState";
                case TRANSACTION_setPackageFreezeUserSetting /* 50 */:
                    return "setPackageFreezeUserSetting";
                case TRANSACTION_getFreezedApplicationList /* 51 */:
                    return "getFreezedApplicationList";
                case TRANSACTION_getUserSettingFreezeableApplicationList /* 52 */:
                    return "getUserSettingFreezeableApplicationList";
                case TRANSACTION_hasFeatureIPC /* 53 */:
                    return "hasFeatureIPC";
                case TRANSACTION_enableFeature /* 54 */:
                    return "enableFeature";
                case TRANSACTION_disableFeature /* 55 */:
                    return "disableFeature";
                case TRANSACTION_enableFeatureMap /* 56 */:
                    return "enableFeatureMap";
                case TRANSACTION_disableFeatureMap /* 57 */:
                    return "disableFeatureMap";
                case TRANSACTION_notifyFeaturesUpdate /* 58 */:
                    return "notifyFeaturesUpdate";
                case TRANSACTION_notifyFeaturesMapUpdate /* 59 */:
                    return "notifyFeaturesMapUpdate";
                case TRANSACTION_registerFeatureObserverInner /* 60 */:
                    return "registerFeatureObserverInner";
                case TRANSACTION_unregisterFeatureObserverInner /* 61 */:
                    return "unregisterFeatureObserverInner";
                case TRANSACTION_registerFeatureMapObserverInner /* 62 */:
                    return "registerFeatureMapObserverInner";
                case TRANSACTION_unregisterFeatureMapObserverInner /* 63 */:
                    return "unregisterFeatureMapObserverInner";
                case 64:
                    return "registerFeatureActionObserverInner";
                case TRANSACTION_unregisterFeatureActionObserverInner /* 65 */:
                    return "unregisterFeatureActionObserverInner";
                case TRANSACTION_appDetailsForwardToMarket /* 66 */:
                    return "appDetailsForwardToMarket";
                case TRANSACTION_markResolveIntentForMarket /* 67 */:
                    return "markResolveIntentForMarket";
                case TRANSACTION_getAbiCheckResult /* 68 */:
                    return "getAbiCheckResult";
                case TRANSACTION_queryIncompatibleApplist /* 69 */:
                    return "queryIncompatibleApplist";
                default:
                    return null;
            }
        }

        public String getTransactionName(int i) {
            return getDefaultTransactionName(i);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOplusPackageManager.DESCRIPTOR);
            }
            switch (i) {
                case 1598968902:
                    parcel2.writeString(IOplusPackageManager.DESCRIPTOR);
                    return true;
                default:
                    switch (i) {
                        case 1:
                            boolean isClosedSuperFirewall = isClosedSuperFirewall();
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isClosedSuperFirewall);
                            return true;
                        case 2:
                            String readString = parcel.readString();
                            parcel.enforceNoDataAvail();
                            Bitmap appIconBitmap = getAppIconBitmap(readString);
                            parcel2.writeNoException();
                            parcel2.writeTypedObject(appIconBitmap, 1);
                            return true;
                        case 3:
                            boolean readBoolean = parcel.readBoolean();
                            parcel.enforceNoDataAvail();
                            Map appIconsCache = getAppIconsCache(readBoolean);
                            parcel2.writeNoException();
                            parcel2.writeMap(appIconsCache);
                            return true;
                        case 4:
                            IPackageDeleteObserver asInterface = IPackageDeleteObserver.Stub.asInterface(parcel.readStrongBinder());
                            parcel.enforceNoDataAvail();
                            Map activityIconsCache = getActivityIconsCache(asInterface);
                            parcel2.writeNoException();
                            parcel2.writeMap(activityIconsCache);
                            return true;
                        case 5:
                            int readInt = parcel.readInt();
                            boolean readBoolean2 = parcel.readBoolean();
                            parcel.enforceNoDataAvail();
                            boolean prohibitChildInstallation = prohibitChildInstallation(readInt, readBoolean2);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(prohibitChildInstallation);
                            return true;
                        case 6:
                            String readString2 = parcel.readString();
                            int readInt2 = parcel.readInt();
                            int readInt3 = parcel.readInt();
                            int readInt4 = parcel.readInt();
                            String readString3 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int oplusFreezePackage = oplusFreezePackage(readString2, readInt2, readInt3, readInt4, readString3);
                            parcel2.writeNoException();
                            parcel2.writeInt(oplusFreezePackage);
                            return true;
                        case 7:
                            String readString4 = parcel.readString();
                            int readInt5 = parcel.readInt();
                            int readInt6 = parcel.readInt();
                            int readInt7 = parcel.readInt();
                            String readString5 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int oplusUnFreezePackage = oplusUnFreezePackage(readString4, readInt5, readInt6, readInt7, readString5);
                            parcel2.writeNoException();
                            parcel2.writeInt(oplusUnFreezePackage);
                            return true;
                        case 8:
                            String readString6 = parcel.readString();
                            int readInt8 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int oplusFreezePackageState = getOplusFreezePackageState(readString6, readInt8);
                            parcel2.writeNoException();
                            parcel2.writeInt(oplusFreezePackageState);
                            return true;
                        case 9:
                            String readString7 = parcel.readString();
                            int readInt9 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            boolean inOplusFreezePackageList = inOplusFreezePackageList(readString7, readInt9);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(inOplusFreezePackageList);
                            return true;
                        case 10:
                            int readInt10 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            List<String> oplusFreezedPackageList = getOplusFreezedPackageList(readInt10);
                            parcel2.writeNoException();
                            parcel2.writeStringList(oplusFreezedPackageList);
                            return true;
                        case 11:
                            String readString8 = parcel.readString();
                            int readInt11 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int oplusPackageFreezeFlag = getOplusPackageFreezeFlag(readString8, readInt11);
                            parcel2.writeNoException();
                            parcel2.writeInt(oplusPackageFreezeFlag);
                            return true;
                        case 12:
                            FeatureInfo[] oplusSystemAvailableFeatures = getOplusSystemAvailableFeatures();
                            parcel2.writeNoException();
                            parcel2.writeTypedArray(oplusSystemAvailableFeatures, 1);
                            return true;
                        case 13:
                            String readString9 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean isSecurePayApp = isSecurePayApp(readString9);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isSecurePayApp);
                            return true;
                        case 14:
                            String readString10 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean isSystemDataApp = isSystemDataApp(readString10);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isSystemDataApp);
                            return true;
                        case 15:
                            int readInt12 = parcel.readInt();
                            String readString11 = parcel.readString();
                            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                            parcel.enforceNoDataAvail();
                            boolean inPmsWhiteList = inPmsWhiteList(readInt12, readString11, createStringArrayList);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(inPmsWhiteList);
                            return true;
                        case 16:
                        case 17:
                        case 19:
                        case 20:
                        case 21:
                        case TRANSACTION_dynamicDetectApp /* 29 */:
                        case TRANSACTION_getSystemUpdateInfo /* 37 */:
                        case TRANSACTION_registerFeatureObserverInner /* 60 */:
                        case TRANSACTION_unregisterFeatureObserverInner /* 61 */:
                        case TRANSACTION_registerFeatureMapObserverInner /* 62 */:
                        case TRANSACTION_unregisterFeatureMapObserverInner /* 63 */:
                        case 64:
                        case TRANSACTION_unregisterFeatureActionObserverInner /* 65 */:
                            return true;
                        case 18:
                            List<String> removableAppList = getRemovableAppList();
                            parcel2.writeNoException();
                            parcel2.writeStringList(removableAppList);
                            return true;
                        case 22:
                            String readString12 = parcel.readString();
                            IntentSender intentSender = (IntentSender) parcel.readTypedObject(IntentSender.CREATOR);
                            Bundle bundle = (Bundle) parcel.readTypedObject(Bundle.CREATOR);
                            parcel.enforceNoDataAvail();
                            boolean restoreRemovableApp = restoreRemovableApp(readString12, intentSender, bundle);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(restoreRemovableApp);
                            return true;
                        case 23:
                            boolean isSupportSessionWrite = isSupportSessionWrite();
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isSupportSessionWrite);
                            return true;
                        case 24:
                            int readInt13 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            List<String> cptListByType = getCptListByType(readInt13);
                            parcel2.writeNoException();
                            parcel2.writeStringList(cptListByType);
                            return true;
                        case 25:
                            int readInt14 = parcel.readInt();
                            String readString13 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean inCptWhiteList = inCptWhiteList(readInt14, readString13);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(inCptWhiteList);
                            return true;
                        case TRANSACTION_inOplusStandardWhiteList /* 26 */:
                            String readString14 = parcel.readString();
                            int readInt15 = parcel.readInt();
                            String readString15 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean inOplusStandardWhiteList = inOplusStandardWhiteList(readString14, readInt15, readString15);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(inOplusStandardWhiteList);
                            return true;
                        case TRANSACTION_sendMapCommonDcsUpload /* 27 */:
                            String readString16 = parcel.readString();
                            String readString17 = parcel.readString();
                            HashMap readHashMap = parcel.readHashMap(getClass().getClassLoader());
                            parcel.enforceNoDataAvail();
                            sendMapCommonDcsUpload(readString16, readString17, readHashMap);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_getIconPackList /* 28 */:
                            List<ApplicationInfo> iconPackList = getIconPackList();
                            parcel2.writeNoException();
                            parcel2.writeTypedList(iconPackList);
                            return true;
                        case TRANSACTION_isDetectApp /* 30 */:
                            String readString18 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean isDetectApp = isDetectApp(readString18);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isDetectApp);
                            return true;
                        case TRANSACTION_getDetectAppList /* 31 */:
                            List<String> detectAppList = getDetectAppList();
                            parcel2.writeNoException();
                            parcel2.writeStringList(detectAppList);
                            return true;
                        case 32:
                            boolean isCrossVersionUpdate = isCrossVersionUpdate();
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isCrossVersionUpdate);
                            return true;
                        case TRANSACTION_getNotInstalledSystemApps /* 33 */:
                            List<String> notInstalledSystemApps = getNotInstalledSystemApps();
                            parcel2.writeNoException();
                            parcel2.writeStringList(notInstalledSystemApps);
                            return true;
                        case TRANSACTION_getValidAppList /* 34 */:
                            List<String> validAppList = getValidAppList();
                            parcel2.writeNoException();
                            parcel2.writeStringList(validAppList);
                            return true;
                        case TRANSACTION_getAppListFromPartition /* 35 */:
                            String readString19 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            List<String> appListFromPartition = getAppListFromPartition(readString19);
                            parcel2.writeNoException();
                            parcel2.writeStringList(appListFromPartition);
                            return true;
                        case TRANSACTION_deletePackageDelegated /* 36 */:
                            String readString20 = parcel.readString();
                            int readInt16 = parcel.readInt();
                            int readInt17 = parcel.readInt();
                            int readInt18 = parcel.readInt();
                            int readInt19 = parcel.readInt();
                            IPackageDeleteObserver asInterface2 = IPackageDeleteObserver.Stub.asInterface(parcel.readStrongBinder());
                            parcel.enforceNoDataAvail();
                            deletePackageDelegated(readString20, readInt16, readInt17, readInt18, readInt19, asInterface2);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_setCustomizeDefaultApp /* 38 */:
                            String readString21 = parcel.readString();
                            String readString22 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean customizeDefaultApp = setCustomizeDefaultApp(readString21, readString22);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(customizeDefaultApp);
                            return true;
                        case TRANSACTION_removeCustomizeDefaultApp /* 39 */:
                            String readString23 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            removeCustomizeDefaultApp(readString23);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_getCustomizeDefaultApp /* 40 */:
                            String readString24 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            String customizeDefaultApp2 = getCustomizeDefaultApp(readString24);
                            parcel2.writeNoException();
                            parcel2.writeString(customizeDefaultApp2);
                            return true;
                        case TRANSACTION_fixupAppData /* 41 */:
                            String readString25 = parcel.readString();
                            String readString26 = parcel.readString();
                            int readInt20 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            boolean fixupAppData = fixupAppData(readString25, readString26, readInt20);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(fixupAppData);
                            return true;
                        case TRANSACTION_getMigMappingPkgName /* 42 */:
                            boolean readBoolean3 = parcel.readBoolean();
                            String readString27 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            String migMappingPkgName = getMigMappingPkgName(readBoolean3, readString27);
                            parcel2.writeNoException();
                            parcel2.writeString(migMappingPkgName);
                            return true;
                        case TRANSACTION_getUninstallableAppConfig /* 43 */:
                            int readInt21 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            List<String> uninstallableAppConfig = getUninstallableAppConfig(readInt21);
                            parcel2.writeNoException();
                            parcel2.writeStringList(uninstallableAppConfig);
                            return true;
                        case TRANSACTION_inUninstallableAppConfig /* 44 */:
                            int readInt22 = parcel.readInt();
                            String readString28 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean inUninstallableAppConfig = inUninstallableAppConfig(readInt22, readString28);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(inUninstallableAppConfig);
                            return true;
                        case TRANSACTION_isFreezeEnabled /* 45 */:
                            boolean isFreezeEnabled = isFreezeEnabled();
                            parcel2.writeNoException();
                            parcel2.writeBoolean(isFreezeEnabled);
                            return true;
                        case TRANSACTION_setFreezeEnable /* 46 */:
                            boolean readBoolean4 = parcel.readBoolean();
                            parcel.enforceNoDataAvail();
                            setFreezeEnable(readBoolean4);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_getPackageFreezeState /* 47 */:
                            String readString29 = parcel.readString();
                            UserHandle userHandle = (UserHandle) parcel.readTypedObject(UserHandle.CREATOR);
                            parcel.enforceNoDataAvail();
                            int packageFreezeState = getPackageFreezeState(readString29, userHandle);
                            parcel2.writeNoException();
                            parcel2.writeInt(packageFreezeState);
                            return true;
                        case TRANSACTION_getPackageFreezeUserSetting /* 48 */:
                            String readString30 = parcel.readString();
                            UserHandle userHandle2 = (UserHandle) parcel.readTypedObject(UserHandle.CREATOR);
                            parcel.enforceNoDataAvail();
                            int packageFreezeUserSetting = getPackageFreezeUserSetting(readString30, userHandle2);
                            parcel2.writeNoException();
                            parcel2.writeInt(packageFreezeUserSetting);
                            return true;
                        case TRANSACTION_setPackageFreezeState /* 49 */:
                            String readString31 = parcel.readString();
                            int readInt23 = parcel.readInt();
                            UserHandle userHandle3 = (UserHandle) parcel.readTypedObject(UserHandle.CREATOR);
                            parcel.enforceNoDataAvail();
                            setPackageFreezeState(readString31, readInt23, userHandle3);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_setPackageFreezeUserSetting /* 50 */:
                            String readString32 = parcel.readString();
                            int readInt24 = parcel.readInt();
                            UserHandle userHandle4 = (UserHandle) parcel.readTypedObject(UserHandle.CREATOR);
                            parcel.enforceNoDataAvail();
                            setPackageFreezeUserSetting(readString32, readInt24, userHandle4);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_getFreezedApplicationList /* 51 */:
                            UserHandle userHandle5 = (UserHandle) parcel.readTypedObject(UserHandle.CREATOR);
                            parcel.enforceNoDataAvail();
                            List<String> freezedApplicationList = getFreezedApplicationList(userHandle5);
                            parcel2.writeNoException();
                            parcel2.writeStringList(freezedApplicationList);
                            return true;
                        case TRANSACTION_getUserSettingFreezeableApplicationList /* 52 */:
                            UserHandle userHandle6 = (UserHandle) parcel.readTypedObject(UserHandle.CREATOR);
                            parcel.enforceNoDataAvail();
                            List<String> userSettingFreezeableApplicationList = getUserSettingFreezeableApplicationList(userHandle6);
                            parcel2.writeNoException();
                            parcel2.writeStringList(userSettingFreezeableApplicationList);
                            return true;
                        case TRANSACTION_hasFeatureIPC /* 53 */:
                            String readString33 = parcel.readString();
                            int readInt25 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            boolean hasFeatureIPC = hasFeatureIPC(readString33, readInt25);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(hasFeatureIPC);
                            return true;
                        case TRANSACTION_enableFeature /* 54 */:
                            String readString34 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean enableFeature = enableFeature(readString34);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(enableFeature);
                            return true;
                        case TRANSACTION_disableFeature /* 55 */:
                            String readString35 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean disableFeature = disableFeature(readString35);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(disableFeature);
                            return true;
                        case TRANSACTION_enableFeatureMap /* 56 */:
                            String readString36 = parcel.readString();
                            int readInt26 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            boolean enableFeatureMap = enableFeatureMap(readString36, readInt26);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(enableFeatureMap);
                            return true;
                        case TRANSACTION_disableFeatureMap /* 57 */:
                            String readString37 = parcel.readString();
                            int readInt27 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            boolean disableFeatureMap = disableFeatureMap(readString37, readInt27);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(disableFeatureMap);
                            return true;
                        case TRANSACTION_notifyFeaturesUpdate /* 58 */:
                            String readString38 = parcel.readString();
                            String readString39 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            notifyFeaturesUpdate(readString38, readString39);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_notifyFeaturesMapUpdate /* 59 */:
                            String readString40 = parcel.readString();
                            String readString41 = parcel.readString();
                            int readInt28 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            notifyFeaturesMapUpdate(readString40, readString41, readInt28);
                            parcel2.writeNoException();
                            return true;
                        case TRANSACTION_appDetailsForwardToMarket /* 66 */:
                            int readInt29 = parcel.readInt();
                            Bundle bundle2 = (Bundle) parcel.readTypedObject(Bundle.CREATOR);
                            parcel.enforceNoDataAvail();
                            Bundle appDetailsForwardToMarket = appDetailsForwardToMarket(readInt29, bundle2);
                            parcel2.writeNoException();
                            parcel2.writeTypedObject(appDetailsForwardToMarket, 1);
                            return true;
                        case TRANSACTION_markResolveIntentForMarket /* 67 */:
                            String readString42 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            boolean markResolveIntentForMarket = markResolveIntentForMarket(readString42);
                            parcel2.writeNoException();
                            parcel2.writeBoolean(markResolveIntentForMarket);
                            return true;
                        case TRANSACTION_getAbiCheckResult /* 68 */:
                            String readString43 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int abiCheckResult = getAbiCheckResult(readString43);
                            parcel2.writeNoException();
                            parcel2.writeInt(abiCheckResult);
                            return true;
                        case TRANSACTION_queryIncompatibleApplist /* 69 */:
                            List<String> queryIncompatibleApplist = queryIncompatibleApplist();
                            parcel2.writeNoException();
                            parcel2.writeStringList(queryIncompatibleApplist);
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
            }
        }

        /* loaded from: classes.dex */
        public static class Proxy implements IOplusPackageManager {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOplusPackageManager.DESCRIPTOR;
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isClosedSuperFirewall() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Bitmap getAppIconBitmap(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bitmap) obtain2.readTypedObject(Bitmap.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Map getAppIconsCache(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeBoolean(z);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Map getActivityIconsCache(IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iPackageDeleteObserver);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean prohibitChildInstallation(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeBoolean(z);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int oplusFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int oplusUnFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getOplusFreezePackageState(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inOplusFreezePackageList(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getOplusFreezedPackageList(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getOplusPackageFreezeFlag(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return (FeatureInfo[]) obtain2.createTypedArray(FeatureInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isSecurePayApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isSystemDataApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inPmsWhiteList(int i, String str, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getRemovableAppList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean restoreRemovableApp(String str, IntentSender intentSender, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeTypedObject(intentSender, 0);
                    obtain.writeTypedObject(bundle, 0);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isSupportSessionWrite() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getCptListByType(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inCptWhiteList(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inOplusStandardWhiteList(String str, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.mRemote.transact(Stub.TRANSACTION_inOplusStandardWhiteList, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void sendMapCommonDcsUpload(String str, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.mRemote.transact(Stub.TRANSACTION_sendMapCommonDcsUpload, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<ApplicationInfo> getIconPackList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getIconPackList, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ApplicationInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isDetectApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_isDetectApp, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getDetectAppList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDetectAppList, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isCrossVersionUpdate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getNotInstalledSystemApps() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getNotInstalledSystemApps, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getValidAppList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getValidAppList, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getAppListFromPartition(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_getAppListFromPartition, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void deletePackageDelegated(String str, int i, int i2, int i3, int i4, IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeStrongInterface(iPackageDeleteObserver);
                    this.mRemote.transact(Stub.TRANSACTION_deletePackageDelegated, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean setCustomizeDefaultApp(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(Stub.TRANSACTION_setCustomizeDefaultApp, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void removeCustomizeDefaultApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_removeCustomizeDefaultApp, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public String getCustomizeDefaultApp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_getCustomizeDefaultApp, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean fixupAppData(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_fixupAppData, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public String getMigMappingPkgName(boolean z, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeBoolean(z);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_getMigMappingPkgName, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getUninstallableAppConfig(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_getUninstallableAppConfig, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inUninstallableAppConfig(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_inUninstallableAppConfig, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isFreezeEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isFreezeEnabled, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void setFreezeEnable(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeBoolean(z);
                    this.mRemote.transact(Stub.TRANSACTION_setFreezeEnable, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getPackageFreezeState(String str, UserHandle userHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_getPackageFreezeState, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getPackageFreezeUserSetting(String str, UserHandle userHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_getPackageFreezeUserSetting, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void setPackageFreezeState(String str, int i, UserHandle userHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_setPackageFreezeState, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void setPackageFreezeUserSetting(String str, int i, UserHandle userHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_setPackageFreezeUserSetting, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getFreezedApplicationList(UserHandle userHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_getFreezedApplicationList, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_getUserSettingFreezeableApplicationList, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean hasFeatureIPC(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_hasFeatureIPC, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean enableFeature(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_enableFeature, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean disableFeature(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_disableFeature, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean enableFeatureMap(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_enableFeatureMap, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean disableFeatureMap(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_disableFeatureMap, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void notifyFeaturesUpdate(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(Stub.TRANSACTION_notifyFeaturesUpdate, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void notifyFeaturesMapUpdate(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(Stub.TRANSACTION_notifyFeaturesMapUpdate, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Bundle appDetailsForwardToMarket(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedObject(bundle, 0);
                    this.mRemote.transact(Stub.TRANSACTION_appDetailsForwardToMarket, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) obtain2.readTypedObject(Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean markResolveIntentForMarket(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_markResolveIntentForMarket, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readBoolean();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getAbiCheckResult(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_getAbiCheckResult, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> queryIncompatibleApplist() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryIncompatibleApplist, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public int getMaxTransactionId() {
            return TRANSACTION_getAbiCheckResult;
        }
    }
}
