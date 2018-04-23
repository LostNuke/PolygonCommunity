package de.polygondev.community.API;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.polygondev.community.ExternalVars;
import de.polygondev.community.stages.BaseGui;

public class GUIApi {
	
	private Inventory GUI;
	private Player player;
	private int index;
	
	private ArrayList<ItemStack> List_Items = new ArrayList<ItemStack>();
	private BaseGui bg;
	
	@SuppressWarnings("unused")
	public GUIApi() {
		Inventory GUI = null;
		Player player = null;
		int index = 0;
		List_Items = new ArrayList<ItemStack>();
		bg = null;
	}
	
	public void createGUI(int space, String name) {
		GUI = Bukkit.createInventory(null, space, name);
		
		this.index = ExternalVars.addGuiToList(this, this.player);
	}
	
	public void addItemToMemory(ItemStack item) {
		this.addItem(item);
	}
	
	/*
	 * @Description: Index2 muss größer sein!
	 */
	public void setItemArea(int index1, int index2, ItemStack item) {
		for (int i = index1; i <= index2; i++) {
			GUI.setItem(i, item);
		}
	}
	
	public void setItem(int index, ItemStack item) {
		GUI.setItem(index, item);
	}
	
	@SuppressWarnings("deprecation")
	public void removeItem(int index) {
		try {
			GUI.remove(index);
		} catch (Exception e) {}
	}
	
	@SuppressWarnings("deprecation")
	public void replaceItem(int index, ItemStack item) {
		try {
			GUI.remove(index);
		} catch (Exception e) {}
		
		GUI.setItem(index, item);
	}
	
	public void openGUI(Player p) {
		p.openInventory(GUI);
	}
	
	public void clearInventory() {
		GUI.clear();
	}
	
	//Getter und Setter für den Player
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	//getter und setter for index
	public int getIndex() {
		return this.index;
	}
	
	//Getter und Setter für die Items
	public void addItem(ItemStack item) {
		List_Items.add(item);
	}
	
	public ItemStack getItemFromIndex(int index) {
		return (List_Items.get(index));
	}
	
	public ItemStack[] getItemArray() throws Exception {
		ItemStack[] cache = new ItemStack[List_Items.size()];
		
		int i = 0;
		for (ItemStack is : List_Items) {
			cache[i] = is;
			i++;
		}
		
		return cache;
	}
	
	//Getter und Setter für das Child-Objekt
	public void setChild(BaseGui bg) {
		this.bg = bg;
	}
	
	public BaseGui getChild() {
		return this.bg;
	}
}