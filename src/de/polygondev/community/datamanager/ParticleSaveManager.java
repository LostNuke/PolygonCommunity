package de.polygondev.community.datamanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.polygondev.community.Community;
import de.polygondev.community.particles.Particle;

public class ParticleSaveManager {
	
	public static File f = new File(Community.plugin.getDataFolder(), "ParticleList.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static void SaveParticleArrayList(ArrayList<Particle> al) {
		
		cfg.set("ComponentSize", al.size());
		
		int i = 0;
		for (Particle par : al) {
			cfg.set("ListComponent" + i + ".Location", par.getLocation());
			cfg.set("ListComponent" + i + ".Effect", par.getEffect().getName());
			cfg.set("ListComponent" + i + ".Interval", par.getInterval());
			cfg.set("ListComponent" + i + ".Quantity", par.getQuantity());
			i++;
		}
		try {
			cfg.save(f);
		} catch (IOException e) {}
	}
	
	public static ArrayList<Particle> ReadParticleArrayList() {
		int size = cfg.getInt("ComponentSize", 0);
		
		ArrayList<Particle> cache = new ArrayList<Particle>();
		
		for (int i = 0; i < size; i++) {
			Location loc = (Location) cfg.get("ListComponent" + i + ".Location");
			Effect effect = Effect.getByName((String) cfg.get("ListComponent" + i + ".Effect"));
			int interval = cfg.getInt("ListComponent" + i + ".Interval");
			int quantity = cfg.getInt("ListComponent" + i + ".Quantity");
			
			Particle cache1 = new Particle();
			cache1.setLocation(loc);
			cache1.setEffect(effect);
			cache1.setInterval(true, interval);
			cache1.setQuantity(quantity);
			cache.add(cache1);
		}
		
		return cache;
	}
	
}
