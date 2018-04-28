package de.polygondev.community.stages;

import de.polygondev.InventoryGui.invGui.InventoryButton;
import de.polygondev.InventoryGui.invGui.InventoryGui;
    import de.polygondev.InventoryGui.invGui.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

    import java.util.ArrayList;
    import java.util.List;

public class StageInventory {

    public StageInventory(Player player) {

        InventoryGui inv = new InventoryGui();
        inv.setName("STAGE");
        inv.setPlayer(player);

        inv.setItemArea(0, 8, Item.CreateBaseItem(Material.AIR, null, 0, null));
        inv.setItem(45, Item.CreateBaseItem(Material.BEDROCK, "BOSS", 0, null));

        InventoryButton btn_inv = new InventoryButton() {

            @Override
            public void onButtonClick(InventoryGui inventoryGui, Player player) {
                player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 100, 100);
                this.setButtonItem(inv, Item.CreateBaseItem(Material.ARROW, ChatColor.BLUE + "Balkandamage", (short) 0 ,null));

                inv.setItemArea(0, 44, Item.CreateBaseItem(Material.STAINED_GLASS_PANE, " ", 15, null));

                inv.removeButton(this);
                inv.updateInventory();
            }

        };

        btn_inv.setPosition(46);
        btn_inv.setButtonItem(inv, Item.CreateBaseItem(Material.ARROW, ChatColor.RED + "Balkandamage", (short) 0 ,null));

        inv.addButton(btn_inv);

        try {
            inv.createInventory();
        } catch (Exception e) {}

        inv.addInventoryToList();
    }

}
