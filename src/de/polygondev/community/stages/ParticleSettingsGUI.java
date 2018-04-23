package de.polygondev.community.stages;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.polygondev.community.permissions.PermissionsManager;

public class ParticleSettingsGUI {
	
	private static ItemStack BlackPane;
	private static ItemStack BackToMenu;
	private static ItemStack BlazePowder;
	
	private static String StageName;
	
	public static Inventory Inventory;
	
	public static boolean CreateElements(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission(PermissionsManager.STAGE_PARTICLES)) {
				
				BlackPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
				ItemMeta BlackMeta = BlackPane.getItemMeta();
				BlackMeta.setDisplayName("");
				BlackPane.setItemMeta(BlackMeta);
				
				BackToMenu = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
				ItemMeta GreenParticleMeta = BackToMenu.getItemMeta();
				GreenParticleMeta.setDisplayName("§aBack to main-menu!");
				BackToMenu.setItemMeta(GreenParticleMeta);
				
				BlazePowder = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
				ItemMeta BlazePowderMeta = BlackPane.getItemMeta();
				BlazePowderMeta.setDisplayName("");
				BlazePowder.setItemMeta(BlazePowderMeta);
				
				Inventory = p.getServer().createInventory(null, 9*3, StageName);
				
				for (int i = 0; i < 4; i++) {
					Inventory.addItem(BlackPane);
				}
				
				Inventory.addItem(BlazePowder);
				
				for (int i = 0; i < 4; i++) {
					Inventory.addItem(BlackPane);
				}
			}
		}
		
		return false;
	}

	public static void eventhandler(InventoryClickEvent e) throws Exception {
		if(e.getInventory().getName().equalsIgnoreCase(StageName)) {
			e.setCancelled(true);
			
		}
	}
}
