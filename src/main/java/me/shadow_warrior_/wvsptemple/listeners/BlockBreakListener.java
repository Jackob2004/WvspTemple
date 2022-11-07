package me.shadow_warrior_.wvsptemple.listeners;

import me.shadow_warrior_.wvsptemple.holders.TempleHolder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.ItemStack;



public class BlockBreakListener extends TempleHolder implements Listener {
  /*   @EventHandler
   public void onBlockBreak2(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.ENCHANTMENT_TABLE)) {
            Location t = e.getBlock().getLocation();
            Player pp = e.getPlayer();

                if (pp.getLocation().distanceSquared(t) <= 25) {

                    pp.sendMessage("message");

                }
            }
        }
*/

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        int random = (int)(Math.random()* 2);

        Player player = e.getPlayer();

        if(player == null) return;
        if (e.getBlock().getType().equals(Material.ENCHANTMENT_TABLE)){
            temple.add(1);
            if (temple.size() == 3 && temple2.size() == 3){
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "3 ulepszenie swiatyni zostalo aktywowane ");
            }else if (temple.size() == 4){
                if (random == 1 && temple2.size() == 3){
                    e.setCancelled(true);
                    temple.remove(3);
                    player.setHealth(player.getHealth() - 2);
                    player.sendMessage(ChatColor.AQUA + " " + ChatColor.BOLD + "Nie zdolales przebic sie przez magiczna osłone swiatyni ");
                    player.playSound(player.getLocation(), Sound.ITEM_BREAK,1,1);
                }else {
                    temple.clear();
                    temple2.clear();
                }
            }

        }

    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + " " + ChatColor.BOLD + "Ulepszenia Swiatyni")) {
            if (e.getCurrentItem() == null) return;

            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "" + ChatColor.BOLD + "Poziom 1") && temple2.size() == 0 && p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT),10)){

                setvalues(10,"Swiatynia zostala ulepszona na 1 poziom",p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "" + ChatColor.BOLD + "Poziom 2") && temple2.size() == 1 && p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT),15)) {

                setvalues(15,"Swiatynia zostala ulepszona na 2 poziom",p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "" + ChatColor.BOLD + "Poziom 3") && temple2.size() == 2 && p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 20)) {

                setvalues(20,"Swiatynia zostala ulepszona na 3 poziom",p);

            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onConsoleCommand(ServerCommandEvent e){
        if (e.getCommand().equalsIgnoreCase("temp24535")){
            temple.clear();
            temple2.clear();
        }
    }
    public void setvalues(int amount,String description,Player p) {
        temple2.add(1);
        p.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT,amount));
        Bukkit.getServer().broadcastMessage(ChatColor.WHITE + "" + ChatColor.BOLD + description);
        p.playSound(p.getLocation(),Sound.FIREWORK_BLAST,1,1);
    }



}
