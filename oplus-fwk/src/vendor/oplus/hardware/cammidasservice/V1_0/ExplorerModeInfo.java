package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ExplorerModeInfo {
    public int HDRRunTimes = 0;
    public int AINRRunTimes = 0;
    public int HDR_AINRRunTimes = 0;
    public int OtherModeRunTimes = 0;
    public double HDRDuration = 0.0d;
    public double AINRDuration = 0.0d;
    public double HDR_AINRDuration = 0.0d;
    public double OtherModeDuration = 0.0d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != ExplorerModeInfo.class) {
            return false;
        }
        ExplorerModeInfo explorerModeInfo = (ExplorerModeInfo) obj;
        if (this.HDRRunTimes == explorerModeInfo.HDRRunTimes && this.AINRRunTimes == explorerModeInfo.AINRRunTimes && this.HDR_AINRRunTimes == explorerModeInfo.HDR_AINRRunTimes && this.OtherModeRunTimes == explorerModeInfo.OtherModeRunTimes && this.HDRDuration == explorerModeInfo.HDRDuration && this.AINRDuration == explorerModeInfo.AINRDuration && this.HDR_AINRDuration == explorerModeInfo.HDR_AINRDuration && this.OtherModeDuration == explorerModeInfo.OtherModeDuration) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.HDRRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.AINRRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.HDR_AINRRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.OtherModeRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.HDRDuration))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.AINRDuration))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.HDR_AINRDuration))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.OtherModeDuration))));
    }

    public final String toString() {
        return "{.HDRRunTimes = " + this.HDRRunTimes + ", .AINRRunTimes = " + this.AINRRunTimes + ", .HDR_AINRRunTimes = " + this.HDR_AINRRunTimes + ", .OtherModeRunTimes = " + this.OtherModeRunTimes + ", .HDRDuration = " + this.HDRDuration + ", .AINRDuration = " + this.AINRDuration + ", .HDR_AINRDuration = " + this.HDR_AINRDuration + ", .OtherModeDuration = " + this.OtherModeDuration + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(48L), 0L);
    }

    public static final ArrayList<ExplorerModeInfo> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<ExplorerModeInfo> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 48, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            ExplorerModeInfo explorerModeInfo = new ExplorerModeInfo();
            explorerModeInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 48);
            arrayList.add(explorerModeInfo);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.HDRRunTimes = hwBlob.getInt32(0 + j);
        this.AINRRunTimes = hwBlob.getInt32(4 + j);
        this.HDR_AINRRunTimes = hwBlob.getInt32(8 + j);
        this.OtherModeRunTimes = hwBlob.getInt32(12 + j);
        this.HDRDuration = hwBlob.getDouble(16 + j);
        this.AINRDuration = hwBlob.getDouble(24 + j);
        this.HDR_AINRDuration = hwBlob.getDouble(32 + j);
        this.OtherModeDuration = hwBlob.getDouble(j + 40);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(48);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<ExplorerModeInfo> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 48);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 48);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.HDRRunTimes);
        hwBlob.putInt32(4 + j, this.AINRRunTimes);
        hwBlob.putInt32(8 + j, this.HDR_AINRRunTimes);
        hwBlob.putInt32(12 + j, this.OtherModeRunTimes);
        hwBlob.putDouble(16 + j, this.HDRDuration);
        hwBlob.putDouble(24 + j, this.AINRDuration);
        hwBlob.putDouble(32 + j, this.HDR_AINRDuration);
        hwBlob.putDouble(j + 40, this.OtherModeDuration);
    }
}
