package de.polygondev.community.datamanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.polygondev.community.Community;

public class BlockLogManager {

	public static File f = new File(Community.plugin.getDataFolder(), "LoggedBlocks.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);

	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void LogBlock(Block block) {
		if (!cfg.contains("block")) {
				
				String[] t1 = new String[] {"" + block.getTypeId()};
				Double[] t2 = new Double[] {1.0};
				cfg.set("block", Arrays.asList(t1));
				cfg.set("count", Arrays.asList(t2));
			} else {
				//block.getTypeId()
				//cfg.getInt("block." + block.getTypeId()) + 1)
				
				boolean notFound = false;
				
				for (int i = 0; i < cfg.getStringList("block").size(); i++) {
					
					if (cfg.getStringList("block").get(i).equals("" + block.getTypeId())) {
						List<Double> ld = cfg.getDoubleList("count");
						ld.set(i, ld.get(i) + 1.0);
						
						cfg.set("count", ld);
						Bukkit.getConsoleSender().sendMessage("$6[Community] " + i + " " + cfg.getDoubleList("count").get(i) + " - " + (cfg.getDoubleList("count").get(i) + 1.0));
						notFound = false;
						break;
					}
					
					notFound = true;
				}
				
				if (notFound == true) {
					List<String> ls = cfg.getStringList("block");
					ls.add("" + block.getTypeId());
					
					List<Double> ld = cfg.getDoubleList("count");
					ld.add(1.0);
					
					cfg.set("block", ls);
					cfg.set("count", ld);
				}
				
				
			}
		save();
		
		//Bukkit.getConsoleSender().sendMessage("?4[Community]OOO " + cfg.getDoubleList("block").get(0) + " _ " + cfg.getDoubleList("count").get(0));
	}

	public static Object[] SortBlocks() {
		List<String> cache1 = cfg.getStringList("block");
		List<Double> cache2 = cfg.getDoubleList("count");
		
		List<String> cs1 = new ArrayList<String>();
		List<Double> cs2 = new ArrayList<Double>();
		
		int index = cfg.getStringList("block").size();
		
		//Geht so oft mal durch wie es objekte gibt
		for (int y = 0; y <= index; y++) {
			
			//Die caches f?r die Sortierung
			Double cache4 = 0.0;
			int x = 0;
			
			//eigentliche sortierung
			for (int i = 0; i < cache2.size(); i++) {
				
				if (cache4 == 0) {
					cache4 = cache2.get(i);
					
				} else {
					if (cache4 < cache2.get(i)) {
						//Groesser
						cache4 = cache2.get(i);
						x = i;
						
					} else if(cache2.get(i).equals(cache4)) {
						//Gleich
						x = i;
						
					} else {
						//Kleiner
					}
				}
			}
			
			//Erstes objekt fertig und n?chstes anfangen
			//Ergebnis in die neuen ArrayLists einspeichern
			
			//?berpr?fen ob noch weitere Daten kommen ansonsten ?berspringen sonst gibts ne Exception
			//W?re auch mit try-catch gegangen aber was solls ^^
			
			try {
				cs1.add(cache1.get(x));
				cache1.remove(x);
				
				cs2.add(cache4);
				cache2.remove(x);
				
				cache4 = 0.0;
				x = 0;
			} catch (Exception e) {}
		}
		
		return new Object[] {cs1, cs2};
	}

}
