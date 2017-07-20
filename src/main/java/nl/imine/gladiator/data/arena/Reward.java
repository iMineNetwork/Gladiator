package nl.imine.gladiator.data.arena;

import nl.imine.gladiator.data.item.CustomItemStack;

import java.io.Serializable;
import java.util.List;

public class Reward implements Serializable {

    private List<CustomItemStack> rewards;

    public Reward() {

    }

    public Reward(List<CustomItemStack> rewards) {
        this.rewards = rewards;
    }

    public List<CustomItemStack> getRewards() {
        return rewards;
    }

    public void setRewards(List<CustomItemStack> rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "rewards=" + rewards +
                '}';
    }
}
