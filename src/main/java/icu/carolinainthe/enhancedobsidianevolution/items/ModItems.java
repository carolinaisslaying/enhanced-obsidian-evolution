package icu.carolinainthe.enhancedobsidianevolution.items;

import icu.carolinainthe.enhancedobsidianevolution.EnhancedObsidianEvolution;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static icu.carolinainthe.enhancedobsidianevolution.EnhancedObsidianEvolution.MOD_ID;

public class ModItems {

    // Registers obsidian scrap as an item
    public static final Item OBSIDIAN_SCRAP = registerItem("obsidian_scrap", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_ALLOY_INGOT = registerItem("obsidian_alloy_ingot", new Item(new FabricItemSettings()));

    // Adds obsidian scrap to the ingredients item group in the creative mode menu
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(OBSIDIAN_SCRAP);
        entries.add(OBSIDIAN_ALLOY_INGOT);
    }

    // Register individual item function, "name" is always "obsidian_scrap". Leaving in case future items are added.
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }

    // Main function to register all items, called in the main class
    public static void registerModItems() {
        EnhancedObsidianEvolution.LOGGER.info("Registering mod items for " + MOD_ID + ", created by Carolina Mitchell (carolina_slays)");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
