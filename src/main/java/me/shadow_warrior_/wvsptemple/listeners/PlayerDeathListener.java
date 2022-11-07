package me.shadow_warrior_.wvsptemple.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import static org.bukkit.potion.PotionEffectType.*;
public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerKill(EntityDeathEvent e) {
        Player player = e.getEntity().getKiller();
        if (player != null) {
            if (player.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
                if (player.hasPermission("eventlistener2.szal")) {
                    player.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 40, 2));
                } else if (player.hasPermission("eventlistener2.szal2")) {
                    player.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 40, 4));
                    player.addPotionEffect(new PotionEffect(REGENERATION, 60, 1));
                } else if (player.hasPermission("eventlistener2.szal3")) {
                    player.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 40, 5));
                    player.addPotionEffect(new PotionEffect(REGENERATION, 120, 1));


                }
            }
        }

    }
}
