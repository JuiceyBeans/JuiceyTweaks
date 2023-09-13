package com.juicey.juiceytweaks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import static com.juicey.juiceytweaks.item.ModItems.BLANK_SMITHING_TEMPLATE;

public class ModItemGroup {
    public static ItemGroup juiceytweaks;

    public static void registerItemGroups() {
        juiceytweaks = FabricItemGroup.builder()
                .icon(() -> new ItemStack(BLANK_SMITHING_TEMPLATE))
                .displayName(Text.translatable("itemGroup.tutorial.test_group"))
                .build();
    }
}
