package vn.sunext.dragonslayer.functions;

import org.bukkit.Bukkit;
import vn.sunext.dragonslayer.DragonSlayer;
import vn.sunext.dragonslayer.managers.PathManager;

public class BroadcastSystem {

    private final DragonSlayer plugin = DragonSlayer.getInstance();

    private final ColorSystem colorSystem = plugin.getColorSystem();

    public void broadcastTheKillerName(String killerName) {
        broadcast(PathManager.PREFIX + PathManager.BROADCAST_MESSAGE.replace("{killer}", killerName));
    }

    public void broadcast(String message) {
        Bukkit.broadcastMessage(colorSystem.color(message));
    }

}
