package android.app.job;

/* loaded from: classes.dex */
public interface IJobInfoExt {

    /* loaded from: classes.dex */
    public static final class JobBuilderExt {
        public boolean mIsOplusJob;

        public JobBuilderExt setRequiresBattIdle(boolean z, int i) {
            return this;
        }
    }

    default boolean getBooleanConstraint(String str, boolean z) {
        return z;
    }

    default String getStringConstraint(String str, String str2) {
        return str2;
    }

    default int getIntConstraint(String str, int i) {
        return i;
    }

    default long getLongConstraint(String str, long j) {
        return j;
    }

    default void setBooleanConstraint(String str, boolean z) {
    }

    default void setStringConstraint(String str, String str2) {
    }

    default void setIntConstraint(String str, int i) {
    }

    default void setLongConstraint(JobInfo jobInfo, String str, long j) {
    }

    default void initJobInfo(Object obj) {
    }

    default void initJobInfoPure(JobBuilderExt jobBuilderExt) {
    }

    default void writeToParcelJobInfo(Object obj, int i) {
    }
}
