package vn.sunext.dragonslayer.functions;

import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import vn.sunext.dragonslayer.DragonSlayer;

public class DragonSystem {

    private final DragonSlayer plugin = DragonSlayer.getInstance();

    private final BroadcastSystem broadcastSystem = plugin.getBroadcastSystem();

    public void onKilledByEntity(LivingEntity livingEntity, EntityDamageEvent damageEvent) {
        Entity damager = null;

        try {
            damager = ((EntityDamageByEntityEvent) damageEvent).getDamager();
        } catch (ClassCastException ignore) {}

        Player whoKill = null;

        if (damager instanceof Player) {
            whoKill = (Player) damager;
        }

        if (damager instanceof Projectile) {
            Projectile p = (Projectile) damager;

            if (p.getShooter() instanceof Player)
                whoKill = (Player) p.getShooter();
        }

        simplifyBroadcast(livingEntity, whoKill);
    }

    public void onKilledByBlock(LivingEntity livingEntity, EntityDamageEvent damageEvent) {
        Block damager = null;

        try {
            damager = ((EntityDamageByBlockEvent) damageEvent).getDamager();
        } catch (ClassCastException ignore) {}

        Player whoKill = null;

        if (damager instanceof TNTPrimed)
            if (((TNTPrimed) damager).getSource() instanceof Player)
                whoKill = (Player) ((TNTPrimed) damager).getSource();

        simplifyBroadcast(livingEntity, whoKill);
    }

    private void simplifyBroadcast(LivingEntity livingEntity, Player whoKill) {
        if (whoKill == null)
            whoKill = livingEntity.getKiller();

        assert whoKill != null;
        broadcastSystem.broadcastTheKillerName(whoKill.getName());
    }

}
