package nl.imine.gladiator.command;

import nl.imine.gladiator.game.ArenaManager;
import nl.imine.gladiator.game.ArenaSessionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class ArenaCommand implements TabExecutor {

    private ArenaSessionManager arenaSessionManager;

    public ArenaCommand(ArenaSessionManager arenaSessionManager) {
        this.arenaSessionManager = arenaSessionManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        if(!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;
        if(args.length < 2) {
            return false;
        }
        if(!args[1].matches("\\d+")) {
            return false;
        }

        ArenaManager arena = arenaSessionManager.getArenaManagers().get(Integer.parseInt(args[1]));
        if(args[0].matches("(join)|(leave)")){
            switch (args[0]) {
                case "join":
                    arena.addPlayer(player);
                    break;
                case "leave":
                    arena.removePlayer(player);
                    break;
                default:
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
        if(args.length == 0) {
            return Arrays.asList("join", "leave");
        }
        return null;
    }
}
