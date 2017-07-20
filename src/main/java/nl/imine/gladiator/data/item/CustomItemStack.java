package nl.imine.gladiator.data.item;

import nl.imine.gladiator.data.common.CustomAttribute;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomItemStack implements Serializable {

    private String itemType;
    private short dataValue;
    private int amount;
    private List<CustomEnchantment> enchantments;
    private List<CustomAttribute> attributes;

    public CustomItemStack() {
    }

    public CustomItemStack(String itemType, short dataValue, int amount, List<CustomEnchantment> enchantments, List<CustomAttribute> attributes) {
        this.itemType = itemType;
        this.dataValue = dataValue;
        this.amount = amount;
        this.enchantments = enchantments;
        this.attributes = attributes;
    }

    public ItemStack toBukkitItemStack() {
        final ItemStack itemStack = new ItemStack(Material.getMaterial(itemType), amount, dataValue);

        enchantments.forEach(customEnchantment -> {
            itemStack.addEnchantment(Enchantment.getByName(customEnchantment.getEnchantment()), customEnchantment.getLevel());
        });

        attributes.forEach(customAttribute -> {
            //TODO Add attributes to items
        });
        return itemStack;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public short getDataValue() {
        return dataValue;
    }

    public void setDataValue(short dataValue) {
        this.dataValue = dataValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<CustomEnchantment> getEnchantments() {
        return enchantments;
    }

    public void setEnchantments(List<CustomEnchantment> enchantments) {
        this.enchantments = enchantments;
    }

    public List<CustomAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CustomAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "CustomItemStack{" +
                "itemType='" + itemType + '\'' +
                ", dataValue=" + dataValue +
                ", enchantments=" + enchantments +
                ", attributes=" + attributes +
                '}';
    }

    public static CustomItemStack emptyItemStack() {
        return new CustomItemStack("AIR", (short) 0, 0, new ArrayList<>(), new ArrayList<>());
    }
}
