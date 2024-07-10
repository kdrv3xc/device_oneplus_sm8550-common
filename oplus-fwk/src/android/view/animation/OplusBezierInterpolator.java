package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class OplusBezierInterpolator extends BaseInterpolator {
    private final float ABOVE_ONE;
    private final float ABOVE_ZERO;
    private final float BELOW_ONE;
    private final boolean DEBUG;
    private final double EPSILON;
    private final String TAG;
    private boolean mAbove;
    private boolean mLimit;
    private OplusUnitBezier mOplusUnitBezier;

    public OplusBezierInterpolator(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public OplusBezierInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        this.TAG = "OplusBezierInterpolator";
        this.DEBUG = false;
        this.EPSILON = 6.25E-5d;
        this.ABOVE_ONE = 1.0f;
        this.BELOW_ONE = 0.9999f;
        this.ABOVE_ZERO = 1.0E-4f;
        this.mAbove = false;
        this.mLimit = false;
    }

    public OplusBezierInterpolator(double d, double d2, double d3, double d4, boolean z) {
        this.TAG = "OplusBezierInterpolator";
        this.DEBUG = false;
        this.EPSILON = 6.25E-5d;
        this.ABOVE_ONE = 1.0f;
        this.BELOW_ONE = 0.9999f;
        this.ABOVE_ZERO = 1.0E-4f;
        this.mAbove = false;
        this.mLimit = false;
        this.mLimit = z;
        this.mOplusUnitBezier = new OplusUnitBezier(d, d2, d3, d4);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double solve = this.mOplusUnitBezier.solve(f, 6.25E-5d);
        if (this.mLimit) {
            if (f < 1.0E-4f || f > 0.9999f) {
                this.mAbove = false;
            }
            if (solve > 1.0d && !this.mAbove) {
                this.mAbove = true;
                solve = 1.0d;
            }
            if (this.mAbove) {
                solve = 1.0d;
            }
        }
        return (float) solve;
    }
}
