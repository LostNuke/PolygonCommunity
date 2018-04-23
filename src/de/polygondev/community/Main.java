package de.polygondev.community;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import de.polygondev.community.datamanager.ParticleSaveManager;
import de.polygondev.community.listener.BlockEvent;
import de.polygondev.community.listener.CommandEvent;
import de.polygondev.community.listener.InteractEvent;
import de.polygondev.community.listener.JoinEvent;
import de.polygondev.community.particles.ParticleSystem;
import de.polygondev.community.stages.ParticleGUI;

public class Main extends JavaPlugin {
	
	public static Main main;
	
	public void onEnable() {
		main = this;
		ExternalVars.plugin = this;
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Community] Das Plugin wurde Aktiviert!");

		getCommand("spawneffect").setExecutor(new CommandEvent());
		getCommand("killeffects").setExecutor(new CommandEvent());
		getCommand("stage").setExecutor(new CommandEvent());
		
		ParticleSystem.List_particle = ParticleSaveManager.ReadParticleArrayList();
		ParticleSystem.StartAll();
		
		Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new BlockEvent(), this);
	}

	public void onDisable() {
		ParticleSystem.RemoveAll();
	}

	public void onLoad() {
	}

}
