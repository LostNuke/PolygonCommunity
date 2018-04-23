package de.polygondev.community.particles;

import org.bukkit.Effect;
import org.bukkit.Location;

import de.polygondev.community.ExternalVars;

public class Particle {
	
	private Location loc;
	private Effect effect;
	private int interval = -1;
	private int quantity = 0;
	public boolean isRunning = false;
	
	private ParticleThread pt;
	
	public Particle() {
		
		pt = new ParticleThread();
		pt.par = this;
		ParticleSystem.AddParticle(this);
	}
	
	//IsRunning -------------------------------------------------------------
	public boolean isRunning() {
		return this.isRunning;
	}
	// ----------------------------------------------------------------------
	
	// Location -------------------------------------------------------------
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public Location getLocation() {
		return this.loc;
	}
	// -----------------------------------------------------------------------

	// SetEffect -------------------------------------------------------------
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	// ----------------------------------------------------------------------

	// Quantity -------------------------------------------------------------
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	// ----------------------------------------------------------------------

	// Interval -------------------------------------------------------------
	public void setInterval(boolean on, int interval) {
		if (on == false) {
			this.interval = -1;
		} else {
			this.interval = interval;
		}
	}
	
	public int getInterval() {
		return this.interval;
	}
	// -----------------------------------------------------------------------

	// Thread ----------------------------------------------------------------
	public void runParticleThread() {
		this.isRunning = true;
		pt.runTaskAsynchronously(ExternalVars.plugin);
	}
	
	public void stopParticleThread() {
		this.isRunning = false;
	}
	// ------------------------------------------------------------------------
}
