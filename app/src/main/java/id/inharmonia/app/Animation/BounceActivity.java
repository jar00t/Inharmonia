package id.inharmonia.app.Animation;

import android.view.animation.Interpolator;

public class BounceActivity implements Interpolator {
    private double amplitude;
    private double frequency;

    public BounceActivity(double amplitude_me, double frequency_me) {
        amplitude = amplitude_me;
        frequency = frequency_me;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ amplitude) * Math.cos(frequency * time) + 1);
    }
}