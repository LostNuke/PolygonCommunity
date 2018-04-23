package de.polygondev.community.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.polygondev.community.datamanager.BlockLogManager;
import de.polygondev.community.permissions.PermissionsManager;

public class BlockEvent implements Listener {
	
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if (!event.getPlayer().hasPermission(PermissionsManager.ADMIN)) {
			BlockLogManager.LogBlock(event.getBlock());
		}
	}
}
