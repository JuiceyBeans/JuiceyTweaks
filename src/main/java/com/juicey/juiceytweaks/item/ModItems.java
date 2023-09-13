package com.juicey.juiceytweaks.item;

import com.juicey.juiceytweaks.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Main.MOD_ID, name), item);
    }
    public static final Item BLANK_SMITHING_TEMPLATE = registerItem("blank_smithing_template", new Item(new FabricItemSettings()));
    public static final Item ELDER_SPIKE = registerItem("elder_spike", new Item(new FabricItemSettings()));

    public static void addItemsToItemGroup() {
        //For future reference:
        //addToItemGroup(ItemGroups.[item group], [mod item]);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.BLANK_SMITHING_TEMPLATE));
        addToItemGroup(ItemGroups.INGREDIENTS, ELDER_SPIKE);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Main.LOGGER.info("Registering items from JuiceyTweaks!");
        addItemsToItemGroup();
    }
}