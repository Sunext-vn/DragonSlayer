package vn.sunext.dragonslayer;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import vn.sunext.dragonslayer.functions.BroadcastSystem;
import vn.sunext.dragonslayer.functions.ColorSystem;
import vn.sunext.dragonslayer.functions.DragonSystem;
import vn.sunext.dragonslayer.listeners.DragonDeathEvent;
import vn.sunext.dragonslayer.managers.PathManager;

@Getter
public final class DragonSlayer extends JavaPlugin {

    private static DragonSlayer plugin;

    private PathManager pathManager;

    private ColorSystem colorSystem;
    private BroadcastSystem broadcastSystem;
    private DragonSystem dragonSystem;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        pathManager = new PathManager();
        pathManager.register();

        colorSystem = new ColorSystem();
        broadcastSystem = new BroadcastSystem();
        dragonSystem = new DragonSystem();

        getServer().getPluginManager().registerEvents(new DragonDeathEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DragonSlayer getInstance() {
        return plugin;
    }

}
