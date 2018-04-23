package de.polygondev.community.particles;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;

import de.polygondev.community.datamanager.ParticleSaveManager;

public class ParticleSystem {
	
	public static void spawnParticle(World world, Location loc, Effect effect) {
		world.playEffect(loc, effect, null);
	}
	
	public static ArrayList<Particle> List_particle = new ArrayList<Particle>();
	
	public static void AddParticle(Particle par) {
		List_particle.add(par);
	}
	
	public static void RemoveParticle(Particle par1) {
		try {
			for (Particle par : List_particle) {
				if (par1 == par) {
					par.stopParticleThread();
					List_particle.remove(par);
				}
			}
		} catch (Exception e) {}
	}
	
	public static void RemoveAll() {
		try {
			
			for (Particle par : List_particle) {
				par.stopParticleThread();
				//TODO In Config speichern
				ParticleSaveManager.SaveParticleArrayList(List_particle);
				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Community] " + List_particle.size());
			}
			
			List_particle = new ArrayList<Particle>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void StartAll() {
		try {
			for (Particle par : List_particle) {
				par.runParticleThread();
			}
		} catch (Exception e) {}
	}
}
