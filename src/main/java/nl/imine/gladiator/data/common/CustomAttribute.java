package nl.imine.gladiator.data.common;

import java.io.Serializable;

public class CustomAttribute implements Serializable {

    private String attribute;
    private String value;

    public CustomAttribute() {
    }

    public CustomAttribute(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
