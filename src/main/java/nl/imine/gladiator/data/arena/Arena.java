package nl.imine.gladiator.data.arena;

import nl.imine.gladiator.data.common.CustomLocation;

import java.io.Serializable;
import java.util.List;

public class Arena implements Serializable {

    private int id;
    private List<CustomLocation> playerSpawns;
    private List<Wave> waves;
    private Reward reward;
    private int maxPlayers;


    public Arena() {

    }

    public Arena(int id, List<CustomLocation> playerSpawns, List<Wave> waves, Reward reward, int maxPlayers) {
        this.id = id;
        this.playerSpawns = playerSpawns;
        this.waves = waves;
        this.reward = reward;
        this.maxPlayers = maxPlayers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CustomLocation> getPlayerSpawns() {
        return playerSpawns;
    }

    public void setPlayerSpawns(List<CustomLocation> playerSpawns) {
        this.playerSpawns = playerSpawns;
    }

    public List<Wave> getWaves() {
        return waves;
    }

    public void setWaves(List<Wave> waves) {
        this.waves = waves;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "id=" + id +
                ", playerSpawns=" + playerSpawns +
                ", waves=" + waves +
                ", reward=" + reward +
                ", maxPlayers=" + maxPlayers +
                '}';
    }
}
