package cl.inacap.tdis08.sapo.captivemonitor.model;

import java.io.Serializable;

public class Range implements Serializable {
    private int min;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
