package de.polygondev.community;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import de.polygondev.InventoryGui.API;
import de.polygondev.community.datamanager.ParticleSaveManager;
import de.polygondev.community.listener.BlockEvent;
import de.polygondev.community.listener.CommandEvent;
import de.polygondev.community.listener.InteractEvent;
import de.polygondev.community.listener.JoinEvent;
import de.polygondev.community.particles.ParticleSystem;

public class Community extends JavaPlugin {
	
	public static Community main;
	public static JavaPlugin plugin = null;
	
	public void onEnable() {
		main = this;
		plugin = this;
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Community] Das Plugin wurde Aktiviert!");
		
		//Inventory API init
		API.activateAPI(this, this.getConfig().getCurrentPath(), null);
		
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
