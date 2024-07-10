package com.oplus.zoomwindow;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class OplusZoomWindowInfo implements Parcelable {
    public static final Parcelable.Creator<OplusZoomWindowInfo> CREATOR = new Parcelable.Creator<OplusZoomWindowInfo>() { // from class: com.oplus.zoomwindow.OplusZoomWindowInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusZoomWindowInfo createFromParcel(Parcel parcel) {
            return new OplusZoomWindowInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusZoomWindowInfo[] newArray(int i) {
            return new OplusZoomWindowInfo[i];
        }
    };

    public OplusZoomWindowInfo() {
    }

    public OplusZoomWindowInfo(Parcel parcel) {
    }

    public OplusZoomWindowInfo(OplusZoomWindowInfo oplusZoomWindowInfo) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public void readFromParcel(Parcel parcel) {
    }
}
