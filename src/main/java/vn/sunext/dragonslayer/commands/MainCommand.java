package vn.sunext.dragonslayer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import vn.sunext.dragonslayer.DragonSlayer;
import vn.sunext.dragonslayer.functions.ColorSystem;
import vn.sunext.dragonslayer.managers.PathManager;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements TabExecutor {

    private final DragonSlayer plugin = DragonSlayer.getInstance();

    private final ColorSystem colorSystem = plugin.getColorSystem();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.getPathManager().register();

                sender.sendMessage(colorSystem.color(PathManager.PREFIX + PathManager.RELOAD_MESSAGE));
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> result = new ArrayList<>();

        if (args.length == 1) {
            if ("reload".startsWith(args[0].toLowerCase()))
                result.add("reload");
        }

        if (!result.isEmpty())
            return result;

        return null;
    }
}
