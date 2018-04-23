package de.polygondev.community.listener;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.polygondev.community.particles.Particle;
import de.polygondev.community.particles.ParticleSystem;
import de.polygondev.community.permissions.PermissionsManager;
import de.polygondev.community.stages.StageGUI;

public class CommandEvent implements CommandExecutor {
	
	int i = 0;
	
	@Override
	public boolean onCommand(CommandSender sender, Command com, String arg2, String[] arg3) {
		if (com.getName().equalsIgnoreCase("spawneffect")) {
			Player p = (Player) sender;
			
			Particle particle = new Particle();
			particle.setLocation(new Location(p.getWorld(), -4.5, 78, 316.5));
			particle.setEffect(Effect.LAVA_POP);
			particle.setQuantity(2);
			particle.setInterval(true, 50);
			particle.runParticleThread();
			
			i++;
		}
		
		if (com.getName().equalsIgnoreCase("killeffects")) {
			ParticleSystem.RemoveAll();
		}
		
		if (com.getName().equalsIgnoreCase("stage")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission(PermissionsManager.ADMIN)) {
					StageGUI stage = new StageGUI();
					stage.createElements(p);
				}
			}
		}
		return false;
	}

}
