package de.polygondev.community;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.polygondev.community.API.GUIApi;

public class ExternalVars {
	public static JavaPlugin plugin = null;
	
	public static ArrayList<GUIApi> List_Guis = new ArrayList<GUIApi>();
	public static ArrayList<Player> List_GuiPlayers = new ArrayList<Player>();
	
	//Setzt die Gui in die Liste und gibt den index zurück
	public static int addGuiToList(GUIApi gui, Player p) {
		
		if (p == null) {
			return (-1);
		}
		
		
		
		int c1 = List_Guis.size();
		int c2 = List_GuiPlayers.size();
		
		if (c1 == c2) {
			ExternalVars.List_Guis.add(gui);
			ExternalVars.List_GuiPlayers.add(p);
			
			return (c1++);
		} else {
			return (-1);
		}
		
		
		
		
	}
}
