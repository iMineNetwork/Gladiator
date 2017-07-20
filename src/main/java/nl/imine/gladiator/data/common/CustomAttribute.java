package nl.imine.gladiator.data.common;

import java.io.Serializable;

public class CustomAttribute implements Serializable {

    private String attribute;
    private double value;

    public CustomAttribute() {
    }

    public CustomAttribute(String attribute, double value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomAttribute{" +
                "attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
