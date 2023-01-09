package vn.sunext.dragonslayer.listeners;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import vn.sunext.dragonslayer.DragonSlayer;

public class DragonDeathEvent implements Listener {

    private final DragonSlayer plugin = DragonSlayer.getInstance();

    @EventHandler
    public void onDragonDeath(EntityDeathEvent event) {
        LivingEntity livingEntity = event.getEntity();
        EntityDamageEvent damageEvent = livingEntity.getLastDamageCause();

        if (livingEntity instanceof EnderDragon) {
            plugin.getDragonSystem().onKilledByEntity(livingEntity, damageEvent);
            plugin.getDragonSystem().onKilledByBlock(livingEntity, damageEvent);
        }


    }

}
