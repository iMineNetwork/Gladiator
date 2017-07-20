package nl.imine.gladiator.game;

import nl.imine.gladiator.Gladiator;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ArenaListener implements Listener {

    private ArenaSessionManager arenaSessionManager;

    public static void init(ArenaSessionManager arenaSessionManager) {
        Bukkit.getPluginManager().registerEvents(new ArenaListener(arenaSessionManager), Gladiator.getPlugin(Gladiator.class));
    }

    public ArenaListener(ArenaSessionManager arenaSessionManager) {
        this.arenaSessionManager = arenaSessionManager;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        arenaSessionManager.handlePlayerDeath(event.getEntity());
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event) {
        arenaSessionManager.handlePlayerDisconnect(event.getPlayer());
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        arenaSessionManager.handleEntityDeath(event.getEntity());
    }
}
