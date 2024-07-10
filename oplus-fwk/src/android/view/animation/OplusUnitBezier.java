package android.view.animation;

/* loaded from: classes.dex */
public class OplusUnitBezier {
    private double f10cy;
    private double f5ax;
    private double f6ay;
    private double f7bx;
    private double f8by;
    private double f9cx;

    public OplusUnitBezier(double d, double d2, double d3, double d4) {
        double d5 = d * 3.0d;
        this.f9cx = d5;
        double d6 = ((d3 - d) * 3.0d) - d5;
        this.f7bx = d6;
        this.f5ax = (1.0d - d5) - d6;
        double d7 = d2 * 3.0d;
        this.f10cy = d7;
        double d8 = ((d4 - d2) * 3.0d) - d7;
        this.f8by = d8;
        this.f6ay = (1.0d - d7) - d8;
    }

    public double sampleCurveX(double d) {
        return ((((this.f5ax * d) + this.f7bx) * d) + this.f9cx) * d;
    }

    public double sampleCurveY(double d) {
        return ((((this.f6ay * d) + this.f8by) * d) + this.f10cy) * d;
    }

    public double sampleCurveDerivativeX(double d) {
        return (((this.f5ax * 3.0d * d) + (this.f7bx * 2.0d)) * d) + this.f9cx;
    }

    public double solveCurveX(double d, double d2) {
        double d3 = d;
        for (int i = 0; i < 8; i++) {
            double sampleCurveX = sampleCurveX(d3) - d;
            if (Math.abs(sampleCurveX) < d2) {
                return d3;
            }
            double sampleCurveDerivativeX = sampleCurveDerivativeX(d3);
            if (Math.abs(sampleCurveDerivativeX) < 1.0E-6d) {
                break;
            }
            d3 -= sampleCurveX / sampleCurveDerivativeX;
        }
        double d4 = 0.0d;
        if (d < 0.0d) {
            return 0.0d;
        }
        double d5 = 1.0d;
        if (d > 1.0d) {
            return 1.0d;
        }
        double d6 = d;
        while (d4 < d5) {
            double sampleCurveX2 = sampleCurveX(d6);
            if (Math.abs(sampleCurveX2 - d) < d2) {
                return d6;
            }
            if (d > sampleCurveX2) {
                d4 = d6;
            } else {
                d5 = d6;
            }
            d6 = ((d5 - d4) * 0.5d) + d4;
        }
        return d6;
    }

    public double solve(double d, double d2) {
        return sampleCurveY(solveCurveX(d, d2));
    }
}
