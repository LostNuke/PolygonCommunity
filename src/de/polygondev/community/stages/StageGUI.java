package de.polygondev.community.stages;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import de.polygondev.community.ExternalVars;
import de.polygondev.community.API.GUIApi;
import de.polygondev.community.API.ItemAPI;

public class StageGUI extends BaseGui{
	
	private static String StageName = "?4StageGUI";
	
	private static ItemStack GreenParticle;
	
	public void createElements(Player p) {
		GUIApi ga = new GUIApi();
		
		//Bitte IMMER in dieser Reihenfolge
		ga.setPlayer(p);
		ga.createGUI(9*5, StageName);
		
//		try {
//			setBlockLog(ga);
//		} catch (Exception e) {}
		
		ItemStack BlackPane = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "?6" ,(short) 15, null);
		ga.setItemArea(9, 24, BlackPane);
		ga.setItemArea(27, 35, BlackPane);
		ga.setItem(37, BlackPane);
		ga.setItem(39, BlackPane);
		ga.setItem(41, BlackPane);
		ga.setItem(43, BlackPane);
		
		ItemStack CommandBlock = ItemAPI.CreateBaseItem(Material.COMMAND, "§bCredit: §2PolygonDev", (short) 0, null);
		ga.setItem(26, CommandBlock);
		
		ItemStack Redstone = ItemAPI.CreateBaseItem(Material.REDSTONE, "§aCommunity-System", (short) 0, null);
		ga.setItem(25, Redstone);
		
		GreenParticle = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§aTo particles!", (short) 13, null);
		ga.setItem(36, GreenParticle);
		
		ItemStack OrangeParticle = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§6Stop particle!", (short) 1, null);
		ga.setItem(38, OrangeParticle);
		
		ItemStack RedGlass = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§cStop all!", (short) 14, null);
		ga.setItem(40, RedGlass);
		
		ItemStack OrangeMusic = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§6Stop music!", (short)1, null);
		ga.setItem(42, OrangeMusic);
		
		ItemStack GreenMusic = ItemAPI.CreateBaseItem(Material.STAINED_GLASS_PANE, "§aTo music!", (short) 13, null);
		ga.setItem(44, GreenMusic);
		
		ga.addItemToMemory(BlackPane);
		ga.addItemToMemory(CommandBlock);
		ga.addItemToMemory(Redstone);
		ga.addItemToMemory(GreenParticle);
		ga.addItemToMemory(OrangeParticle);
		ga.addItemToMemory(RedGlass);
		ga.addItemToMemory(OrangeMusic);
		ga.addItemToMemory(GreenMusic);
		
		ga.openGUI(p);
		//ParticleGUI.CreateElements(sender);
	}
	
//	@SuppressWarnings({ "unchecked", "deprecation" })
//	private void setBlockLog(GUIApi ga) throws Exception {
//		//BlockLogs
//		Object[] c = BlockLogManager.SortBlocks();
//		List<String> BlockIDs = (List<String>) c[0];
//		List<Double> BlockCount = (List<Double>) c[1];
//		
//		for (int i = 0; i < 9; i++) {
//			int BlockLogID = Integer.valueOf(BlockIDs.get(i));
//			BlockLog = new ItemStack(BlockLogID);
//			ItemMeta BlockLogMeta = BlockLog.getItemMeta();
//			BlockLogMeta.setDisplayName(BlockIDs.get(i));
//			List<String> lore1 = new ArrayList<String>();
//			lore1.add("" + BlockCount.get(i));
//			BlockLogMeta.setLore(lore1);
//			BlockLog.setItemMeta(BlockLogMeta);
//			
//			ga.replaceItem(i, BlockLog);
//		}
//	}
	
	//Click-Handler ^^ -----------------------------------------------------------------
	public static void eventhandler(InventoryClickEvent e) {
		if(e.getInventory().getName().equalsIgnoreCase(StageName)) {
			e.setCancelled(true);
			
			Player p = (Player) e.getWhoClicked();
			
			//Testen ob wirklich der Spieler gedr?ckt hat
			int i = 0;
			for (Player p1 : ExternalVars.List_GuiPlayers) {
				if (p1.getName().equals(p.getName())) {
						
					GUIApi gui = ExternalVars.List_Guis.get(i);
					
					//Die verschiedenen Items rausholen und ?berpr?fen
					//Hier gibt es von 0 - 7 Items
					ItemStack[] cache = null;
					try {
						cache = ExternalVars.List_Guis.get(i).getItemArray();
					} catch (Exception e1) {}
					
					if (cache == null) {
						return;
					}
					
					p.sendMessage("" + p.getName() + " | " + p1.getName());
					p.sendMessage(e.getCurrentItem().getItemMeta().getDisplayName() + " | " + cache[1].getItemMeta().getDisplayName());
					p.sendMessage("index: " + gui.getIndex() + " count all -1: " + (ExternalVars.List_Guis.size() -1));
					
					//BlackPane
					if (e.getCurrentItem().equals(cache[0])) {
						for(Player p2 : Bukkit.getOnlinePlayers()) {
							if(p2.getOpenInventory().getTitle().equals(StageName)) {
								if(p2.getOpenInventory().getCursor().equals(GreenParticle)) {
									ParticleGUI pg = new ParticleGUI();
									pg.CreateElements(p2);
								}
							}
						}
						
					}
					
					//CommandBlock
					if (e.getCurrentItem().equals(cache[1])) {
						
					}
					
					//Redstone
					if (e.getCurrentItem().equals(cache[2])) {
						
					}
					
					//GreenParticle
					if (e.getCurrentItem().equals(cache[3])) {
						ParticleGUI pg = new ParticleGUI();
						pg.CreateElements(e.getWhoClicked());
					}
					
					//OrangeParticle
					if (e.getCurrentItem().equals(cache[4])) {
						
					}
					
					//RedGlass
					if (e.getCurrentItem().equals(cache[5])) {
						
					}
					
					//OrangeMusic
					if (e.getCurrentItem().equals(cache[6])) {
						
					}
					
					//GreenMusic
					if (e.getCurrentItem().equals(cache[7])) {
						
					}
				}
				
				i++;
			}
		}
	}

}
