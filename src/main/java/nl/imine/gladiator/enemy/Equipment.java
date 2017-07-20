package nl.imine.gladiator.enemy;

import nl.imine.gladiator.data.item.CustomItemStack;

import java.io.Serializable;

public class Equipment implements Serializable {

    private CustomItemStack head;
    private CustomItemStack torso;
    private CustomItemStack legs;
    private CustomItemStack feet;

    private CustomItemStack mainHand;
    private CustomItemStack offHand;

    public Equipment() {

    }

    public Equipment(CustomItemStack head, CustomItemStack torso, CustomItemStack legs, CustomItemStack feet, CustomItemStack mainHand, CustomItemStack offHand) {
        this.head = head;
        this.torso = torso;
        this.legs = legs;
        this.feet = feet;
        this.mainHand = mainHand;
        this.offHand = offHand;
    }

    public CustomItemStack getHead() {
        return head == null ? CustomItemStack.emptyItemStack() : head;
    }

    public void setHead(CustomItemStack head) {
        this.head = head;
    }

    public CustomItemStack getTorso() {
        return torso == null ? CustomItemStack.emptyItemStack() : torso;
    }

    public void setTorso(CustomItemStack torso) {
        this.torso = torso;
    }

    public CustomItemStack getLegs() {
        return legs == null ? CustomItemStack.emptyItemStack() : legs;
    }

    public void setLegs(CustomItemStack legs) {
        this.legs = legs;
    }

    public CustomItemStack getFeet() {
        return feet == null ? CustomItemStack.emptyItemStack() : feet;
    }

    public void setFeet(CustomItemStack feet) {
        this.feet = feet;
    }

    public CustomItemStack getMainHand() {
        return mainHand == null ? CustomItemStack.emptyItemStack() : mainHand;
    }

    public void setMainHand(CustomItemStack mainHand) {
        this.mainHand = mainHand;
    }

    public CustomItemStack getOffHand() {
        return offHand == null ? CustomItemStack.emptyItemStack() : offHand;
    }

    public void setOffHand(CustomItemStack offHand) {
        this.offHand = offHand;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "head=" + head +
                ", torso=" + torso +
                ", legs=" + legs +
                ", feet=" + feet +
                ", mainHand=" + mainHand +
                ", offHand=" + offHand +
                '}';
    }
}
