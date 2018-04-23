package de.polygondev.community.stages;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import de.polygondev.community.ExternalVars;
import de.polygondev.community.API.GUIApi;
import de.polygondev.community.API.ItemAPI;
import de.polygondev.community.permissions.PermissionsManager;

public class ParticleGUI extends BaseGui {
	
	private static String StageName = "§4ParticleGui";
	
	private GUIApi ga;
	
	public void CreateElements(CommandSender sender) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission(PermissionsManager.STAGE_PARTICLES)) {
				
				ga = new GUIApi();
				ga.setPlayer(p);
				ga.setChild(this);
				ga.createGUI(9*6, StageName);
				
				ItemStack BlackPane = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§0", (short) 15, null);
				ga.setItemArea(36, 43, BlackPane);
				ga.setItem(45, BlackPane);
				ga.setItemArea(47, 51, BlackPane);
				ga.setItem(53, BlackPane);
				
				ItemStack NextPage = ItemAPI.CreateHeadItem("Next Page", "MHF_ArrowRight", null);
				ga.setItem(44, NextPage);
				
				ItemStack GreenParticle = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§aBack to main-menu!", (short) 13, null);
				ga.setItem(46, GreenParticle);
				
				ItemStack OrangeParticle = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§6Stop particle!", (short) 1, null);
				ga.setItem(52, OrangeParticle);
				
				ItemStack PreviousPage = ItemAPI.CreateHeadItem("§6Previous Page", "MHF_ArrowLeft", null);
				
				ga.addItemToMemory(BlackPane);
				ga.addItemToMemory(NextPage);
				ga.addItemToMemory(GreenParticle);
				ga.addItemToMemory(OrangeParticle);
				ga.addItem(PreviousPage);
				
				createParticleItems();
				ga.openGUI(p);
				
			}
		}
		return;
	}
	
	public void createParticleItems() {
		
		for (int i = 0; i < 36; i++) {
			ga.removeItem(i);
		}
		
		// Index 5 - 41
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.BLAZE_POWDER, "§6Blaze-Shoot", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.ARROW, "§6BowFire", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.DIAMOND_SWORD, "§6Click1", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.WOOL, "§6Cloud", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Coloured_Dust", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.DIAMOND_SWORD, "§6Critical", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.ACACIA_DOOR_ITEM, "§6Door_Toggle", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.EYE_OF_ENDER, "§6Ender-Signal", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.TNT, "§6Explosion", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.TNT, "§6HugeExplosion", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.TNT, "§6LargeExplosion", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.BREWING_STAND_ITEM, "§6Extinguish", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.FIREWORK, "§6Firework-Spark", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.FLINT_AND_STEEL, "§6Flame", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.WATER_BUCKET, "§6Flying_Glyph", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.SAND, "§6Foot-Step", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.FIREBALL, "§6Ghast-Shoot", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.GHAST_TEAR, "§6Ghast-Shriek", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.EMERALD, "§6Happy-Villager", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Heart", (short)1, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.NETHER_STAR, "§6Instant-Spell", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Item_Break", (short) 15, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Large_Smoke", (short) 15, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.LAVA_BUCKET, "§6Lava_Pop", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.LAVA_BUCKET, "§6LavaDrip", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.GLASS_BOTTLE, "§6Magic-Crit", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.MOB_SPAWNER, "§6MobSpawner_Flame", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.NOTE_BLOCK, "§6Note", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6particle Smoke", (short) 15, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.OBSIDIAN, "§6Portal", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.GLASS_BOTTLE, "§6Potion_Break", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.POTION, "§6Potion_Swirl", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.EXP_BOTTLE, "§6Potion Swirl Transparent", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.NOTE_BLOCK, "§6Record_Play", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.SLIME_BALL, "§6Slime", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Small Smoke", (short) 15, null));
		
		ga.removeItem(36);
		ga.removeItem(44);
		
		ga.setItem(36, ga.getItemFromIndex(0));
		ga.setItem(44, ga.getItemFromIndex(1));
		
		for (int i = 5; i < 41; i++) {
			ga.setItem(i -5, ga.getItemFromIndex(i));
		}
	}
	
	//Zweite Seite
	public void createParticleItemsPage2() {
		
		for (int i = 0; i < 36; i++) {
			try {
				ga.removeItem(i);
			} catch (Exception e) {}
		}
		
		ga.removeItem(36);
		ga.removeItem(44);
		
		//Index 42 - 55
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Smoke", (short) 15, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.IRON_SPADE, "§6Snow-Shovel", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.SNOW_BALL, "§6SnowBall Break", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.ENCHANTED_BOOK, "§6Spell", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.WATER_BUCKET, "§6Splash", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.SAND, "§6Step_Sound", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.BONE, "§6Tile Break", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.INK_SACK, "§6Tile Dust", (short) 15, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.CLAY_BALL, "§6Villger-ThunderCloud", (short) 0, null));
		
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.BEDROCK, "§6Void-Fog", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.WATER_BUCKET, "§6WaterDrip", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.ENCHANTED_BOOK, "§6Witch-Magic", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.IRON_DOOR, "§6Zombie Destroy Door", (short) 0, null));
		ga.addItemToMemory(ItemAPI.CreateBaseItem(Material.BARRIER, "§4§lMore Particles incoming!", (short) 0, null));
		
		ga.setItem(44, ga.getItemFromIndex(5));
		
		ga.setItem(36, ga.getItemFromIndex(5));
		
		ga.setItem(44, ga.getItemFromIndex(0));
		
		for (int i = 42; i < 68; i++) {
			if (i < 54) {
				ga.setItem(i -42, ga.getItemFromIndex(i));
			} else {
				ga.setItem(i -42, ga.getItemFromIndex(55));
			}
		}
	}
	
	//Click-Handler ^^ -----------------------------------------------------------------
	public static void eventhandler(InventoryClickEvent e) {
		if(e.getInventory().getName().equalsIgnoreCase(StageName)) {
			e.setCancelled(true);
			Player p = (Player) e.getWhoClicked();
			
			int i = 0;
			for (Player p1 : ExternalVars.List_GuiPlayers) {
				if (p1.getName().equals(p.getName())) {
					
					GUIApi gui = ExternalVars.List_Guis.get(i);
					
					ItemStack[] cache = null;
					try {
						cache = ExternalVars.List_Guis.get(i).getItemArray();
					} catch (Exception e1) {}
					
					if (cache == null) {
						p.sendMessage("Tja das ist wohl nicht so einfach!");
						return;
					}
					
					p.sendMessage("" + p.getName() + " | " + p1.getName());
					p.sendMessage(e.getCurrentItem().getItemMeta().getDisplayName() + " | " + cache[1].getItemMeta().getDisplayName());
					p.sendMessage("index: " + gui.getIndex() + " count all -1: " + (ExternalVars.List_Guis.size() -1));
					
					if (e.getCurrentItem().equals(cache[1])) {
						if (p.getOpenInventory().getTitle().equals(StageName)) {
							((ParticleGUI) gui.getChild()).createParticleItemsPage2();
						}
						
					}
					
					if (e.getCurrentItem().equals(cache[2])) {
						StageGUI sg = new StageGUI();
						sg.createElements((Player) e.getWhoClicked());
					}
					
					if (e.getCurrentItem().equals(cache[4])) {
						if (p.getOpenInventory().getTitle().equals(StageName)) {
							((ParticleGUI) gui.getChild()).createParticleItems();
						}
					}
					
					//Particle Anfang
					//Blaze-Shoot
					if (e.getCurrentItem().equals(cache[5])) {
						
					}
					
					//BowFire
					if (e.getCurrentItem().equals(cache[6])) {
						
					}

					//Blaze-Shoot
					if (e.getCurrentItem().equals(cache[7])) {
						
					}
					
					//Click1
					if (e.getCurrentItem().equals(cache[8])) {
						
					}
					
					//Cloud
					if (e.getCurrentItem().equals(cache[9])) {
						
					}
					
					//Coloured_Dust
					if (e.getCurrentItem().equals(cache[10])) {
						
					}
					
					//Critical
					if (e.getCurrentItem().equals(cache[11])) {
						
					}
					
					//Door_Toggle
					if (e.getCurrentItem().equals(cache[12])) {
						
					}
					
					//Ender-Signal
					if (e.getCurrentItem().equals(cache[13])) {
						
					}
					
					//Explosion
					if (e.getCurrentItem().equals(cache[14])) {
						
					}
						
				}	
			}
			
		}
	}

}
