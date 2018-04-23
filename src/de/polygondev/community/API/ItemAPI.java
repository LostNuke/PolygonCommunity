package de.polygondev.community.API;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemAPI {
	
	/*
	 * @Description: Creates new Basic Items with name, damage and lore
	 */
	public static ItemStack CreateBaseItem(Material material, String name, short damage, List<String> lore) {
		ItemStack Item = null;
		
		if (material != null) {
			Item = new ItemStack(material, 1, (short) damage);
		} else {
			new ItemStack(Material.STONE, 1, (short) damage);
		}
		
		ItemMeta Meta = Item.getItemMeta();
		Meta.setDisplayName(name);
		
		if (lore != null) {
			Meta.setLore(lore);
		}
		
		Item.setItemMeta(Meta);
		return Item;
	}
	
	/*
	 * @Description: Creates new Skull Items with name, damage and lore
	 */
	public static ItemStack CreateHeadItem(String name, String skullowner, List<String> lore) {
		ItemStack Skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta skullmeta = (SkullMeta) Skull.getItemMeta();
		if(lore != null) {
			skullmeta.setLore(lore);
		}
		skullmeta.setDisplayName(name);
		skullmeta.setOwner(skullowner);
		Skull.setItemMeta(skullmeta);
		
		return Skull;
		
	}
	
	

}
