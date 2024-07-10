package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import oplus.app.IOplusCommonManager;

/* loaded from: classes.dex */
public final class ExplorerInfo {
    public int operationMode = 0;
    public double startTime = 0.0d;
    public double endTime = 0.0d;
    public double[] sensorDuration = new double[8];
    public ExplorerExceptionInfo exceptionInfo = new ExplorerExceptionInfo();
    public ExplorerModeInfo modeInfo = new ExplorerModeInfo();
    public ExplorerTempInfo tempInfo = new ExplorerTempInfo();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != ExplorerInfo.class) {
            return false;
        }
        ExplorerInfo explorerInfo = (ExplorerInfo) obj;
        if (this.operationMode == explorerInfo.operationMode && this.startTime == explorerInfo.startTime && this.endTime == explorerInfo.endTime && HidlSupport.deepEquals(this.sensorDuration, explorerInfo.sensorDuration) && HidlSupport.deepEquals(this.exceptionInfo, explorerInfo.exceptionInfo) && HidlSupport.deepEquals(this.modeInfo, explorerInfo.modeInfo) && HidlSupport.deepEquals(this.tempInfo, explorerInfo.tempInfo)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.operationMode))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.startTime))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.endTime))), Integer.valueOf(HidlSupport.deepHashCode(this.sensorDuration)), Integer.valueOf(HidlSupport.deepHashCode(this.exceptionInfo)), Integer.valueOf(HidlSupport.deepHashCode(this.modeInfo)), Integer.valueOf(HidlSupport.deepHashCode(this.tempInfo)));
    }

    public final String toString() {
        return "{.operationMode = " + this.operationMode + ", .startTime = " + this.startTime + ", .endTime = " + this.endTime + ", .sensorDuration = " + Arrays.toString(this.sensorDuration) + ", .exceptionInfo = " + this.exceptionInfo + ", .modeInfo = " + this.modeInfo + ", .tempInfo = " + this.tempInfo + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(200L), 0L);
    }

    public static final ArrayList<ExplorerInfo> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<ExplorerInfo> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * IOplusCommonManager.SECTION_INDEX, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            ExplorerInfo explorerInfo = new ExplorerInfo();
            explorerInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * IOplusCommonManager.SECTION_INDEX);
            arrayList.add(explorerInfo);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.operationMode = hwBlob.getInt32(0 + j);
        this.startTime = hwBlob.getDouble(8 + j);
        this.endTime = hwBlob.getDouble(16 + j);
        hwBlob.copyToDoubleArray(24 + j, this.sensorDuration, 8);
        this.exceptionInfo.readEmbeddedFromParcel(hwParcel, hwBlob, 88 + j);
        this.modeInfo.readEmbeddedFromParcel(hwParcel, hwBlob, 112 + j);
        this.tempInfo.readEmbeddedFromParcel(hwParcel, hwBlob, j + 160);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(IOplusCommonManager.SECTION_INDEX);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<ExplorerInfo> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * IOplusCommonManager.SECTION_INDEX);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * IOplusCommonManager.SECTION_INDEX);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.operationMode);
        hwBlob.putDouble(8 + j, this.startTime);
        hwBlob.putDouble(16 + j, this.endTime);
        long j2 = 24 + j;
        double[] dArr = this.sensorDuration;
        if (dArr == null || dArr.length != 8) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        hwBlob.putDoubleArray(j2, dArr);
        this.exceptionInfo.writeEmbeddedToBlob(hwBlob, 88 + j);
        this.modeInfo.writeEmbeddedToBlob(hwBlob, 112 + j);
        this.tempInfo.writeEmbeddedToBlob(hwBlob, j + 160);
    }
}
