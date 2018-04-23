package de.polygondev.community.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.polygondev.community.stages.ParticleGUI;
import de.polygondev.community.stages.StageGUI;

public class InteractEvent implements Listener {

	// CMDstage Interact
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		
		try {
			StageGUI.eventhandler(e);
		} catch (Exception e1) {}
		
		try {
			ParticleGUI.eventhandler(e);
		} catch (Exception e1) {}
	}
}
