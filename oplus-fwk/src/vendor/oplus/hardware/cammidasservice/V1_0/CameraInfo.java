package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CameraInfo {
    public int physicalCameraId = 0;
    public int isActive = 0;
    public SensorDimension sensorOutDimension = new SensorDimension();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != CameraInfo.class) {
            return false;
        }
        CameraInfo cameraInfo = (CameraInfo) obj;
        if (this.physicalCameraId == cameraInfo.physicalCameraId && this.isActive == cameraInfo.isActive && HidlSupport.deepEquals(this.sensorOutDimension, cameraInfo.sensorOutDimension)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.physicalCameraId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.isActive))), Integer.valueOf(HidlSupport.deepHashCode(this.sensorOutDimension)));
    }

    public final String toString() {
        return "{.physicalCameraId = " + this.physicalCameraId + ", .isActive = " + this.isActive + ", .sensorOutDimension = " + this.sensorOutDimension + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(16L), 0L);
    }

    public static final ArrayList<CameraInfo> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<CameraInfo> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 16, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            CameraInfo cameraInfo = new CameraInfo();
            cameraInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 16);
            arrayList.add(cameraInfo);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.physicalCameraId = hwBlob.getInt32(0 + j);
        this.isActive = hwBlob.getInt32(4 + j);
        this.sensorOutDimension.readEmbeddedFromParcel(hwParcel, hwBlob, j + 8);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(16);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<CameraInfo> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 16);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 16);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.physicalCameraId);
        hwBlob.putInt32(4 + j, this.isActive);
        this.sensorOutDimension.writeEmbeddedToBlob(hwBlob, j + 8);
    }
}
