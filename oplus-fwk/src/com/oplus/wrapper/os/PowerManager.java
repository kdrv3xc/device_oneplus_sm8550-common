package com.oplus.wrapper.os;

/* loaded from: classes.dex */
public class PowerManager {
    public static final int USER_ACTIVITY_EVENT_OTHER = getUserActivityEventOther();
    public static final int WAKE_REASON_APPLICATION = getWakeReasonApplication();
    private final android.os.PowerManager mPowerManager;

    public PowerManager(android.os.PowerManager powerManager) {
        this.mPowerManager = powerManager;
    }

    private static int getUserActivityEventOther() {
        return 0;
    }

    private static int getWakeReasonApplication() {
        return 2;
    }

    public int getMaximumScreenBrightnessSetting() {
        return this.mPowerManager.getMaximumScreenBrightnessSetting();
    }

    public int getMinimumScreenBrightnessSetting() {
        return this.mPowerManager.getMinimumScreenBrightnessSetting();
    }

    public void wakeUp(long j, String str) {
        this.mPowerManager.wakeUp(j, str);
    }

    public void wakeUp(long j, int i, String str) {
        this.mPowerManager.wakeUp(j, i, str);
    }

    public int getDefaultScreenBrightnessSetting() {
        return this.mPowerManager.getDefaultScreenBrightnessSetting();
    }

    public PowerSaveState getPowerSaveState(int i) {
        android.os.PowerSaveState powerSaveState = this.mPowerManager.getPowerSaveState(i);
        if (powerSaveState == null) {
            return null;
        }
        return new PowerSaveState(powerSaveState);
    }

    public int getLastSleepReason() {
        return this.mPowerManager.getLastSleepReason();
    }

    public void shutdown(boolean z, String str, boolean z2) {
        this.mPowerManager.shutdown(z, str, z2);
    }

    public void reboot(String str) {
        this.mPowerManager.reboot(str);
    }

    public void goToSleep(long j) {
        this.mPowerManager.goToSleep(j);
    }

    public void userActivity(long j, int i, int i2) {
        this.mPowerManager.userActivity(j, i, i2);
    }

    public boolean setPowerSaveModeEnabled(boolean z) {
        return this.mPowerManager.setPowerSaveModeEnabled(z);
    }
}
