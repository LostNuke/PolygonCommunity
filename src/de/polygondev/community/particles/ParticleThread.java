package de.polygondev.community.particles;

import org.bukkit.scheduler.BukkitRunnable;

public class ParticleThread extends BukkitRunnable {
	
	public Particle par;
	
	@Override
	public void run() {
		while (par.isRunning()) {
			
			for (int i = 0; i < par.getQuantity(); i++) {
				ParticleSystem.spawnParticle(par.getLocation().getWorld(), par.getLocation(), par.getEffect());
			}
			
			if (par.getInterval() != -1) {
				try {
					Thread.sleep(par.getInterval());
				} catch (InterruptedException e) {}
			}
		}
	}
}
