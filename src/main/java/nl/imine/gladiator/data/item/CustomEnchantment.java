package nl.imine.gladiator.data.item;

import java.io.Serializable;

public class CustomEnchantment implements Serializable {

    private String enchantment;
    private int level;

    public CustomEnchantment() {
    }

    public CustomEnchantment(String enchantment, int level) {
        this.enchantment = enchantment;
        this.level = level;
    }

    public String getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(String enchantment) {
        this.enchantment = enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CustomEnchantment{" +
                "enchantment='" + enchantment + '\'' +
                ", level=" + level +
                '}';
    }
}
