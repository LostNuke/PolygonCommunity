package de.polygondev.community.stages;

        import de.polygondev.InventoryGui.invGui.InventoryGui;
        import de.polygondev.InventoryGui.invGui.Item;
        import org.bukkit.Material;
        import org.bukkit.entity.Player;

public class StageInventory {

    public StageInventory(Player player) {

        InventoryGui inv = new InventoryGui();
        inv.setPlayer(player);

        inv.setItemArea(1, 9, Item.CreateBaseItem(Material.STONE, "TEST", (short) 0, null));
        inv.setItemArea(10, 45, Item.CreateBaseItem(Material.STAINED_GLASS_PANE, "", (short) 14, null));
        inv.addItem(Item.CreateHeadItem("DonkeyKong", "Donkey", null));

        try {
            inv.createInventory();
        } catch (Exception e) {}

        inv.setName("STAGE");
        inv.addInventoryToList();
    }

}
