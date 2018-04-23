package de.polygondev.community.permissions;

import org.bukkit.permissions.Permission;

public class PermissionsManager {
	public static Permission ADMIN = new Permission("Community.Admin"); //Alle Rechte
	
	public static Permission STAGE = new Permission("Community.Stage.Menu"); //Recht um das Men� zu �ffnen
	public static Permission STAGE_PARTICLES = new Permission("Community.Stage.Particle"); //Recht um das Partikel-Men� zu �ffnen
	
	public static Permission CREATE_PARTICLES = new Permission("Community.Particles.Create"); //Bestimmte Anzahl in Config einstellen
	public static Permission DELETE_PARTICLES = new Permission("Community.Particles.Delete"); //Kann nur eigene Sehen/L�schen (au�er er hat Permission ADMIN, dann ist es eh egal)
}
