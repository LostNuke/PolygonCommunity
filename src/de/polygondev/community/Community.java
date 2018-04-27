package de.polygondev.community;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.polygondev.InventoryGui.API;
import de.polygondev.InventoryGui.EventExtender;
import de.polygondev.InventoryGui.invGui.InventoryGui;
import de.polygondev.community.datamanager.ParticleSaveManager;
import de.polygondev.community.listener.BlockEvent;
import de.polygondev.community.listener.CommandEvent;
import de.polygondev.community.particles.ParticleSystem;

public class Community extends JavaPlugin {
	
	public static Community main;
	public static JavaPlugin plugin = null;
	
	public void onEnable() {
		main = this;
		plugin = this;

		//Inventory API init
		EventExtender ex = new EventExtender() {

			@Override
			public void onInventoryClick(InventoryClickEvent arg0, InventoryGui arg1) {
				// TODO Auto-generated method stub
				Bukkit.getServer().getConsoleSender().sendMessage("Hey! Du bist noch nicht so lange hier was?");
			}

			@Override
			public void onInventoryClose(InventoryCloseEvent arg0, InventoryGui arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPlayerQuit(PlayerQuitEvent arg0, InventoryGui arg1) {
				// TODO Auto-generated method stub
				
			}
			
		};

        API.activateAPI(this, this.getConfig().getCurrentPath(), ex);
		
		getCommand("spawneffect").setExecutor(new CommandEvent());
		getCommand("killeffects").setExecutor(new CommandEvent());
		getCommand("stage").setExecutor(new CommandEvent());
		
		ParticleSystem.List_particle = ParticleSaveManager.ReadParticleArrayList();
		ParticleSystem.StartAll();
		
		Bukkit.getPluginManager().registerEvents(new BlockEvent(), this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Community] Das Plugin wurde Aktiviert!");
	}

	public void onDisable() {
		ParticleSystem.RemoveAll();
	}

	public void onLoad() {
	}

}
