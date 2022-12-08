package me.shadow_warrior_.wvsptemple;

import me.shadow_warrior_.wvsptemple.commands.TempleReset;
import me.shadow_warrior_.wvsptemple.listeners.BlockBreakListener;
import me.shadow_warrior_.wvsptemple.listeners.BlockClickListener;
import me.shadow_warrior_.wvsptemple.listeners.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class WvspTemple extends JavaPlugin {

//TODO finish temple updates(maybe make it more advanced),finish skills for warriors, Daily Quests, abilities for monsters that cannot damage allies ,maybe lotto,Top players
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(),this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(),this);
        getServer().getPluginManager().registerEvents(new BlockClickListener(),this);
        getCommand("temp24535").setExecutor(new TempleReset());
    }
    
}
