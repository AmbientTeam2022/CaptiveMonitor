package cl.inacap.tdis08.sapo.captivemonitor.model;

import java.io.Serializable;

public class Range implements Serializable {
    private Double min;
    private Double max;

    public Range(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }
}
