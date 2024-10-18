package com.juiceybeans.juiceytweaks.item;

import com.juiceybeans.juiceytweaks.JuiceyTweaks;
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
        return Registry.register(Registries.ITEM, new Identifier(JuiceyTweaks.MOD_ID, name), item);
    }
    public static final Item BLANK_SMITHING_TEMPLATE = registerItem("blank_smithing_template", new Item(new FabricItemSettings()));

    public static void addItemsToItemGroup() {
        //For future reference:
        //addToItemGroup(ItemGroups.[item group], [mod item]);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.BLANK_SMITHING_TEMPLATE));
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        JuiceyTweaks.LOGGER.info("Registered items!");
        addItemsToItemGroup();
    }
}