package nl.imine.gladiator;

import nl.imine.gladiator.command.ArenaCommand;
import nl.imine.gladiator.data.arena.Arena;
import nl.imine.gladiator.data.arena.Reward;
import nl.imine.gladiator.data.arena.Wave;
import nl.imine.gladiator.data.common.CustomLocation;
import nl.imine.gladiator.data.item.CustomItemStack;
import nl.imine.gladiator.data.service.ArenaService;
import nl.imine.gladiator.enemy.Enemy;
import nl.imine.gladiator.enemy.Equipment;
import nl.imine.gladiator.game.ArenaManager;
import nl.imine.gladiator.game.ArenaSessionManager;
import org.bukkit.Bukkit;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gladiator extends JavaPlugin {

    public ArenaSessionManager arenaSessionManager;

    public static void main(String[] args) throws Exception {
        ArenaService service = new ArenaService();

        for(Arena arena : service.loadArenas(Paths.get("Arena.ser"))){
            System.out.println(arena);
        }



//        Arena arena = createTestArena();
//        Path path = Paths.get("Arena.ser");
//
//        if (Files.exists(path)) {
//            Files.delete(path);
//        }
//
//        Files.createFile(path);
//        BufferedWriter out = Files.newBufferedWriter(path);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        out.write(objectMapper.writeValueAsString(arena));
//        out.flush();
//        out.close();
    }

    @Override
    public void onEnable() {
        List<Arena> arenas = new ArenaService().loadArenas(getDataFolder().toPath().resolve(Paths.get("arenas.json")));
        List<ArenaManager> arenaManagers = arenas.stream().map(ArenaManager::new).collect(Collectors.toList());
        arenaSessionManager = ArenaSessionManager.init(arenaManagers);

        TabExecutor arenaCommand = new ArenaCommand(arenaSessionManager);
        getCommand("arena").setTabCompleter(arenaCommand);
        getCommand("arena").setExecutor(arenaCommand);
    }

    @Override
    public void onDisable() {
        arenaSessionManager.stopAllArenas();
    }

    public static Arena createTestArena(){
        List<CustomLocation> playerSpawns = new ArrayList<>();
        playerSpawns.add(new CustomLocation(Bukkit.getWorlds().get(0).getName(), 100, 200, 300, 1, 0.5f));

        List<Wave> waves = new ArrayList<>();

        List<Enemy> enemySpawns = new ArrayList<>();
        enemySpawns.add(new Enemy(null, 1, EntityType.ZOMBIE, new CustomLocation(Bukkit.getWorlds().get(0).getName(), 1, 2, 3, 4, 5), new Equipment(null, null, null, null, null, null), null));
        Wave wave = new Wave(enemySpawns);
        waves.add(wave);

        List<CustomItemStack> rewards = new ArrayList<>();
        rewards.add(new CustomItemStack("STONE", (short) 2, 5, new ArrayList<>(), new ArrayList<>()));
        Reward reward = new Reward(rewards);

        return new Arena(0, playerSpawns, waves, reward, 12);
    }
}
