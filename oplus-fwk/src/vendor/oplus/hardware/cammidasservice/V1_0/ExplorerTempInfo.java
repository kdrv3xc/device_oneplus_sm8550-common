package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ExplorerTempInfo {
    public float[] DDRTemp = new float[2];
    public float[] NPUTemp = new float[2];
    public float[] ISPTemp = new float[2];
    public float[] MAXCPUTemp = new float[2];
    public float[] surfaceTemp = new float[2];

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != ExplorerTempInfo.class) {
            return false;
        }
        ExplorerTempInfo explorerTempInfo = (ExplorerTempInfo) obj;
        if (HidlSupport.deepEquals(this.DDRTemp, explorerTempInfo.DDRTemp) && HidlSupport.deepEquals(this.NPUTemp, explorerTempInfo.NPUTemp) && HidlSupport.deepEquals(this.ISPTemp, explorerTempInfo.ISPTemp) && HidlSupport.deepEquals(this.MAXCPUTemp, explorerTempInfo.MAXCPUTemp) && HidlSupport.deepEquals(this.surfaceTemp, explorerTempInfo.surfaceTemp)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(this.DDRTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.NPUTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.ISPTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.MAXCPUTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.surfaceTemp)));
    }

    public final String toString() {
        return "{.DDRTemp = " + Arrays.toString(this.DDRTemp) + ", .NPUTemp = " + Arrays.toString(this.NPUTemp) + ", .ISPTemp = " + Arrays.toString(this.ISPTemp) + ", .MAXCPUTemp = " + Arrays.toString(this.MAXCPUTemp) + ", .surfaceTemp = " + Arrays.toString(this.surfaceTemp) + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(40L), 0L);
    }

    public static final ArrayList<ExplorerTempInfo> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<ExplorerTempInfo> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 40, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            ExplorerTempInfo explorerTempInfo = new ExplorerTempInfo();
            explorerTempInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 40);
            arrayList.add(explorerTempInfo);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        hwBlob.copyToFloatArray(0 + j, this.DDRTemp, 2);
        hwBlob.copyToFloatArray(8 + j, this.NPUTemp, 2);
        hwBlob.copyToFloatArray(16 + j, this.ISPTemp, 2);
        hwBlob.copyToFloatArray(24 + j, this.MAXCPUTemp, 2);
        hwBlob.copyToFloatArray(j + 32, this.surfaceTemp, 2);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(40);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<ExplorerTempInfo> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 40);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 40);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        long j2 = 0 + j;
        float[] fArr = this.DDRTemp;
        if (fArr == null || fArr.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        hwBlob.putFloatArray(j2, fArr);
        long j3 = 8 + j;
        float[] fArr2 = this.NPUTemp;
        if (fArr2 == null || fArr2.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        hwBlob.putFloatArray(j3, fArr2);
        long j4 = 16 + j;
        float[] fArr3 = this.ISPTemp;
        if (fArr3 == null || fArr3.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        hwBlob.putFloatArray(j4, fArr3);
        long j5 = 24 + j;
        float[] fArr4 = this.MAXCPUTemp;
        if (fArr4 == null || fArr4.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        hwBlob.putFloatArray(j5, fArr4);
        long j6 = j + 32;
        float[] fArr5 = this.surfaceTemp;
        if (fArr5 == null || fArr5.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        hwBlob.putFloatArray(j6, fArr5);
    }
}
