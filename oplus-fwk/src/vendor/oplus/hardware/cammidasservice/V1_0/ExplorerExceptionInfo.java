package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ExplorerExceptionInfo {
    public int moduleId = 0;
    public int majorType = 0;
    public int minorType = 0;
    public int level = 0;
    public int action = 0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != ExplorerExceptionInfo.class) {
            return false;
        }
        ExplorerExceptionInfo explorerExceptionInfo = (ExplorerExceptionInfo) obj;
        if (this.moduleId == explorerExceptionInfo.moduleId && this.majorType == explorerExceptionInfo.majorType && this.minorType == explorerExceptionInfo.minorType && this.level == explorerExceptionInfo.level && this.action == explorerExceptionInfo.action) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.moduleId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.majorType))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.minorType))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.level))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.action))));
    }

    public final String toString() {
        return "{.moduleId = " + this.moduleId + ", .majorType = " + this.majorType + ", .minorType = " + this.minorType + ", .level = " + this.level + ", .action = " + this.action + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(20L), 0L);
    }

    public static final ArrayList<ExplorerExceptionInfo> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<ExplorerExceptionInfo> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 20, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            ExplorerExceptionInfo explorerExceptionInfo = new ExplorerExceptionInfo();
            explorerExceptionInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 20);
            arrayList.add(explorerExceptionInfo);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.moduleId = hwBlob.getInt32(0 + j);
        this.majorType = hwBlob.getInt32(4 + j);
        this.minorType = hwBlob.getInt32(8 + j);
        this.level = hwBlob.getInt32(12 + j);
        this.action = hwBlob.getInt32(j + 16);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(20);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<ExplorerExceptionInfo> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 20);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 20);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.moduleId);
        hwBlob.putInt32(4 + j, this.majorType);
        hwBlob.putInt32(8 + j, this.minorType);
        hwBlob.putInt32(12 + j, this.level);
        hwBlob.putInt32(j + 16, this.action);
    }
}
