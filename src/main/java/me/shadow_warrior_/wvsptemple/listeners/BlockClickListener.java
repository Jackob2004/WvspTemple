package me.shadow_warrior_.wvsptemple.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class BlockClickListener implements Listener {

    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {
        if(e.getAction() == null || e.getClickedBlock()== null || e.getClickedBlock().getType()== null) return;
        Player p = e.getPlayer();
        Material block = e.getClickedBlock().getType();
        Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.GOLD + " " + ChatColor.BOLD + "Ulepszenia Swiatyni");


        ItemStack enchant1 = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
        ItemMeta ench1 = enchant1.getItemMeta();
        ench1.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Poziom 1");
        ench1.addEnchant(Enchantment.DURABILITY, 1, true);
        enchant1.setItemMeta(ench1);

        ItemStack enchant2 = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
        ItemMeta ench2 = enchant2.getItemMeta();
        ench2.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Poziom 2");
        ench2.addEnchant(Enchantment.DURABILITY, 1, true);
        enchant2.setItemMeta(ench2);

        ItemStack enchant3 = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
        ItemMeta ench3 = enchant3.getItemMeta();
        ench3.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Poziom 3");
        ench3.addEnchant(Enchantment.DURABILITY, 1, true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Cena: 30 sztabek zlota");
        lore.add(ChatColor.BLUE + "Ulepszenie aktywuje magiczna tarcze swiatyni dzieki ktorej");
        lore.add(ChatColor.BLUE + "potwory beda mialy 50% szans na zniszczenie 4 kawalka swiatyni.");
        lore.add(ChatColor.BLUE + "W przypadku nieprzebicia sie przez oslone potwor otrzyma rowniez obrazenia");
        ench3.setLore(lore);

        enchant3.setItemMeta(ench3);

        inventory.setItem(2, enchant1);
        // inventory.setItem(3, star);
        inventory.setItem(4, enchant2);
        // inventory.setItem(5, star);
        inventory.setItem(6, enchant3);
        // inventory.setItem(7, star);

        if(block == null) return;
        if(e.getAction() == null) return;
        if (!p.hasPotionEffect(PotionEffectType.WATER_BREATHING)) return;

        if (e.getAction() == Action.LEFT_CLICK_BLOCK && p.isSneaking() && block.equals(Material.ENCHANTMENT_TABLE)) p.openInventory(inventory);

    }
}


