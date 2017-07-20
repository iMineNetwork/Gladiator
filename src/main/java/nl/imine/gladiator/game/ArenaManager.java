package nl.imine.gladiator.game;

import nl.imine.gladiator.Gladiator;
import nl.imine.gladiator.data.arena.Arena;
import nl.imine.gladiator.data.common.CustomAttribute;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaManager {

    private Arena arena;
    private int currentWave;
    private List<Player> players;
    private List<Entity> currentEnemies;
    private boolean isStarted;

    public ArenaManager(Arena arena) {
        this.arena = arena;
        this.currentWave = 0;
        this.players = new ArrayList<>();
        this.currentEnemies = new ArrayList<>();
        this.isStarted = false;
    }

    public void addPlayer(Player player) {
        if (players.size() <= arena.getMaxPlayers() && !isStarted) {
            players.add(player);
            if(players.size() == 1) {
                System.out.println("Start timer");
                //START TIMER 60 SECONDEN EN DAN GAME START
            }
            player.sendMessage("You will be sent to the arena when the game starts");
            startArena();
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
        if(players.isEmpty()) {
            stopArena();
        }
        System.out.println(player.getName() + " left the arena");
    }

    public void startArena() {
        System.out.println(arena);
        players.forEach(player -> {
            player.teleport(arena.getPlayerSpawns().get(new Random().nextInt(arena.getPlayerSpawns().size())).toBukkitLocation());
            player.sendTitle("Prepare for the trials", "", 100, 100, 100);
        });

        Bukkit.getScheduler().scheduleSyncDelayedTask(Gladiator.getPlugin(Gladiator.class), () -> {
            startWave(currentWave);
        }, 200);
    }

    public void stopArena() {
        currentEnemies.forEach(Entity::remove);
        players.forEach(player -> {
            player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        });
    }

    public void removeEntity(Entity entity) {
        currentEnemies.remove(entity);
        if(currentEnemies.isEmpty()) {
            endWave();
        }
        System.out.println("Enemy killed [ "  + entity + "]");
    }

    public void startWave(int wave) {
        players.forEach(player -> {
            player.sendTitle("Wave " + currentWave, "", 200, 200, 200);
        });
        Bukkit.getScheduler().scheduleSyncDelayedTask(Gladiator.getPlugin(Gladiator.class), () -> {
            arena.getWaves().get(wave).getEnemySpawns().forEach(enemySpawn -> {
                for(int i = 0; i < enemySpawn.getCount(); i++) {
                    LivingEntity enemy = (LivingEntity) enemySpawn.getSpawnLocation().toBukkitLocation().getWorld().spawnEntity(enemySpawn.getSpawnLocation().toBukkitLocation(), enemySpawn.getEntityType());

                    //Give the enemy it's weapons. Fill everything so no random armor should be added.
                    enemy.getEquipment().setHelmet(enemySpawn.getEquipment().getHead().toBukkitItemStack());
                    enemy.getEquipment().setChestplate(enemySpawn.getEquipment().getTorso().toBukkitItemStack());
                    enemy.getEquipment().setLeggings(enemySpawn.getEquipment().getLegs().toBukkitItemStack());
                    enemy.getEquipment().setBoots(enemySpawn.getEquipment().getFeet().toBukkitItemStack());
                    enemy.getEquipment().setItemInMainHand(enemySpawn.getEquipment().getMainHand().toBukkitItemStack());
                    enemy.getEquipment().setItemInOffHand(enemySpawn.getEquipment().getOffHand().toBukkitItemStack());

                    //Set the enemy's itemDropChance to 0 to prevent equipment from dropping
                    enemy.getEquipment().setHelmetDropChance(0);
                    enemy.getEquipment().setChestplateDropChance(0);
                    enemy.getEquipment().setLeggingsDropChance(0);
                    enemy.getEquipment().setBootsDropChance(0);
                    enemy.getEquipment().setItemInMainHandDropChance(0);
                    enemy.getEquipment().setItemInOffHandDropChance(0);

                    enemy.setCustomName(enemySpawn.getCustomName());
                    enemy.setRemoveWhenFarAway(false);

                    for (CustomAttribute attribute : enemySpawn.getAttributes()) {
                        enemy.getAttribute(Attribute.valueOf(attribute.getAttribute())).setBaseValue(attribute.getValue());
                    }

                    enemy.setHealth(enemy.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    currentEnemies.add(enemy);
                }
            });
        }, 200);
;
    }

    public void endWave() {
        players.forEach(player -> {
            player.sendTitle("Round defeated", (arena.getWaves().size() - currentWave) + "waves left", 200, 200, 200);
        });
        currentWave++;
        if (currentWave < arena.getWaves().size()) {
            startWave(currentWave);
        } else {
            players.forEach(player -> {
                player.sendTitle("You Won!", "", 100, 100, 100);
            });
            Bukkit.getScheduler().scheduleSyncDelayedTask(Gladiator.getPlugin(Gladiator.class), () -> {
                players.forEach(player -> {
                    arena.getReward().getRewards().get(new Random().nextInt(arena.getReward().getRewards().size()));
                });
            });
            stopArena();
        }
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Entity> getCurrentEnemies() {
        return currentEnemies;
    }

    public void setCurrentEnemies(List<Entity> currentEnemies) {
        this.currentEnemies = currentEnemies;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }
}
