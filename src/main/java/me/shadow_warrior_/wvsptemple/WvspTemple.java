package me.shadow_warrior_.wvsptemple;

import me.shadow_warrior_.wvsptemple.commands.TempleReset;
import me.shadow_warrior_.wvsptemple.listeners.BlockBreakListener;
import me.shadow_warrior_.wvsptemple.listeners.BlockClickListener;
import me.shadow_warrior_.wvsptemple.listeners.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class WvspTemple extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(),this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(),this);
        getServer().getPluginManager().registerEvents(new BlockClickListener(),this);
        getCommand("temp24535").setExecutor(new TempleReset());
    }
    
}
