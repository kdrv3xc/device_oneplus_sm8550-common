package com.oplus.wrapper.hardware.camera2;

import com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative;

/* loaded from: classes.dex */
public class CaptureResult {
    private final android.hardware.camera2.CaptureResult mCaptureResult;

    public CaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        this.mCaptureResult = captureResult;
    }

    public CameraMetadataNative getNativeMetadata() {
        android.hardware.camera2.impl.CameraMetadataNative nativeMetadata = this.mCaptureResult.getNativeMetadata();
        if (nativeMetadata == null) {
            return null;
        }
        return new CameraMetadataNative(nativeMetadata);
    }

    public CameraMetadataNative getNativeCopy() {
        android.hardware.camera2.impl.CameraMetadataNative nativeCopy = this.mCaptureResult.getNativeCopy();
        if (nativeCopy == null) {
            return null;
        }
        return new CameraMetadataNative(nativeCopy);
    }

    /* loaded from: classes.dex */
    public static final class Key<T> {
        private final Key<T> mKey;

        public Key(Key<T> key) {
            this.mKey = key;
        }

        public Key(String str, Class<T> cls, long j) {
            this.mKey = new Key<>(str, cls, j);
        }

        public Key(String str, Class<T> cls) {
            this.mKey = new Key<>(str, cls);
        }

        public Key(String str, String str2, Class<T> cls) {
            this.mKey = new Key<>(str, str2, cls);
        }

        public Key<T> getKey() {
            return this.mKey;
        }

        public long getVendorId() {
            return this.mKey.getVendorId();
        }
    }
}
