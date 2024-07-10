package com.oplus.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class OplusAppInfo implements Parcelable {
    public static final int ACTIVITY_TYPE_ASSISTANT = 4;
    public static final int ACTIVITY_TYPE_HOME = 2;
    public static final int ACTIVITY_TYPE_RECENTS = 3;
    public static final int ACTIVITY_TYPE_STANDARD = 1;
    public static final int ACTIVITY_TYPE_UNDEFINED = 0;
    public static final Parcelable.Creator<OplusAppInfo> CREATOR = new Parcelable.Creator<OplusAppInfo>() { // from class: com.oplus.app.OplusAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusAppInfo createFromParcel(Parcel parcel) {
            return new OplusAppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusAppInfo[] newArray(int i) {
            return new OplusAppInfo[i];
        }
    };
    public static final int WINDOWING_MODE_FREEFORM = 5;
    public static final int WINDOWING_MODE_FULLSCREEN = 1;
    public static final int WINDOWING_MODE_PINNED = 2;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_PRIMARY = 3;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_SECONDARY = 4;
    public static final int WINDOWING_MODE_UNDEFINED = 0;
    public int activityType;
    public Rect appBounds;
    public ApplicationInfo appInfo;
    public int displayId;
    public Bundle extension;
    public boolean isRootActivity;
    public String launchedFromPackage;
    public int orientation;
    public int taskId;
    public ComponentName topActivity;
    public int userId;
    public int windowingMode;

    public OplusAppInfo() {
        this.appBounds = new Rect();
        this.orientation = -1;
        this.isRootActivity = false;
        this.extension = new Bundle();
    }

    public OplusAppInfo(OplusAppInfo oplusAppInfo) {
        this.appBounds = new Rect();
        this.orientation = -1;
        this.isRootActivity = false;
        this.extension = new Bundle();
        if (oplusAppInfo != null) {
            this.windowingMode = oplusAppInfo.windowingMode;
            this.activityType = oplusAppInfo.activityType;
            this.appBounds = oplusAppInfo.appBounds;
            this.taskId = oplusAppInfo.taskId;
            this.topActivity = oplusAppInfo.topActivity;
            this.displayId = oplusAppInfo.displayId;
            this.orientation = oplusAppInfo.orientation;
            this.userId = oplusAppInfo.userId;
            this.launchedFromPackage = oplusAppInfo.launchedFromPackage;
            this.isRootActivity = oplusAppInfo.isRootActivity;
            this.extension = oplusAppInfo.extension;
        }
    }

    public OplusAppInfo(Parcel parcel) {
        this.appBounds = new Rect();
        this.orientation = -1;
        this.isRootActivity = false;
        this.extension = new Bundle();
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.windowingMode = parcel.readInt();
        this.activityType = parcel.readInt();
        this.taskId = parcel.readInt();
        this.appBounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        if (parcel.readInt() != 0) {
            this.appInfo = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.topActivity = (ComponentName) ComponentName.CREATOR.createFromParcel(parcel);
        }
        this.displayId = parcel.readInt();
        this.orientation = parcel.readInt();
        this.userId = parcel.readInt();
        this.launchedFromPackage = parcel.readString();
        this.isRootActivity = parcel.readBoolean();
        this.extension = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.windowingMode);
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.taskId);
        parcel.writeParcelable(this.appBounds, i);
        if (this.appInfo != null) {
            parcel.writeInt(1);
            this.appInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.topActivity != null) {
            parcel.writeInt(1);
            this.topActivity.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.displayId);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.userId);
        parcel.writeString(this.launchedFromPackage);
        parcel.writeBoolean(this.isRootActivity);
        parcel.writeBundle(this.extension);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OplusAppInfo{");
        sb.append("windowingMode=" + this.windowingMode);
        sb.append(", activityType=" + this.activityType);
        sb.append(", taskId=" + this.taskId);
        sb.append(", appBounds=" + this.appBounds);
        sb.append(", appInfo=" + this.appInfo);
        sb.append(", topActivity=" + this.topActivity);
        sb.append(", displayId=" + this.displayId);
        sb.append(", orientation=" + this.orientation);
        sb.append(", userId=" + this.userId);
        sb.append(", launchedFromPackage=" + this.launchedFromPackage);
        sb.append(", isRootActivity=" + this.isRootActivity);
        sb.append(", extension=" + this.extension);
        sb.append("}");
        return sb.toString();
    }
}
