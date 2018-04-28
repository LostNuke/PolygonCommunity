package de.polygondev.community.stages;

import de.polygondev.InventoryGui.invGui.InventoryGui;
    import de.polygondev.InventoryGui.invGui.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;
    import org.bukkit.entity.Player;

    import java.util.ArrayList;
    import java.util.List;

public class StageInventory {

    public StageInventory(Player player) {

        InventoryGui inv = new InventoryGui();
        inv.setPlayer(player);

        inv.setItemArea(1, 9, Item.CreateBaseItem(Material.AIR, null, (short) 0, null));
        inv.setItemArea(10, 45, Item.CreateBaseItem(Material.STAINED_GLASS_PANE, " ", (short) 15, null));
        inv.addItem(Item.CreateHeadItem("DonkeyKong", "Donkey", null));

        try {
            inv.createInventory();
        } catch (Exception e) {}

        inv.setName("STAGE");
        inv.addInventoryToList();
    }

}
