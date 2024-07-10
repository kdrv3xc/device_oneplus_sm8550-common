package com.oplus.wrapper.hardware.camera2;

/* loaded from: classes.dex */
public class CaptureRequest {

    /* loaded from: classes.dex */
    public static final class Key<T> {
        private final Key<T> mKey;

        public Key(String str, Class<T> cls, long j) {
            this.mKey = new Key<>(str, cls, j);
        }

        public Key(String str, Class<T> cls) {
            this.mKey = new Key<>(str, cls);
        }

        public Key<T> getKey() {
            return this.mKey;
        }
    }
}
