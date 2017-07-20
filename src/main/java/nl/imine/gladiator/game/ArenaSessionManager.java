package nl.imine.gladiator.game;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class ArenaSessionManager {

    private List<ArenaManager> arenaManagers;

    public static ArenaSessionManager init(List<ArenaManager> arenas) {
        ArenaSessionManager arenaSessionManager = new ArenaSessionManager(arenas);
        ArenaListener.init(arenaSessionManager);
        return arenaSessionManager;
    }

    public ArenaSessionManager(List<ArenaManager> arenaManagers) {
        this.arenaManagers = arenaManagers;
    }

    public List<ArenaManager> getArenaManagers() {
        return arenaManagers;
    }

    public void setArenaManagers(List<ArenaManager> arenaManagers) {
        this.arenaManagers = arenaManagers;
    }

    public void handlePlayerDisconnect(Player player) {
        for(ArenaManager manager : arenaManagers) {
            manager.removePlayer(player);
        }
    }

    public void handlePlayerDeath(Player player) {
        for(ArenaManager manager : arenaManagers) {
            manager.removePlayer(player);
        }
    }

    public void handleEntityDeath(Entity entity) {
        for(ArenaManager manager : arenaManagers) {
            manager.removeEntity(entity);
        }
    }

    public void stopAllArenas() {
        for(ArenaManager manager : arenaManagers) {
            manager.stopArena();
        }
    }
}
