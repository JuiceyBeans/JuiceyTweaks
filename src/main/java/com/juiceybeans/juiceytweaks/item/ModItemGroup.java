package com.juiceybeans.juiceytweaks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ModItemGroup {
    public static ItemGroup juiceytweaks;

    public static void registerItemGroups() {
        juiceytweaks = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.BLANK_SMITHING_TEMPLATE))
                .displayName(Text.translatable("itemGroup.juiceytweaks.juicey_tweaks"))
                .build();
    }
}
