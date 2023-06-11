package com.juicey.jtweaks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import static com.juicey.jtweaks.item.ModItems.BLANK_SMITHING_TEMPLATE;

public class ModItemGroup {
    public static ItemGroup JTWEAKS;

    public static void registerItemGroups() {
        JTWEAKS = FabricItemGroup.builder()
                .icon(() -> new ItemStack(BLANK_SMITHING_TEMPLATE))
                .displayName(Text.translatable("itemGroup.tutorial.test_group"))
                .build();
    }
}
