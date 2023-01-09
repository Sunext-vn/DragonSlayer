package vn.sunext.dragonslayer.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.dragonslayer.DragonSlayer;

import java.io.File;

public class PathManager {

    private final DragonSlayer plugin = DragonSlayer.getInstance();

    public static String PREFIX = "";

    public static String RELOAD_MESSAGE = "";
    public static String BROADCAST_MESSAGE = "";

    public void register() {
        File config_file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(config_file);

        PREFIX = config.getString("prefix");

        RELOAD_MESSAGE = config.getString("messages.reload");
        BROADCAST_MESSAGE = config.getString("messages.broadcast");
    }

}
