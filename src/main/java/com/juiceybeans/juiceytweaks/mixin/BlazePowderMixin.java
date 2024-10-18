package com.juiceybeans.juiceytweaks.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class BlazePowderMixin {
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=blaze_powder"
                    )
            ),
            at = @At(
                    value = "INVOKE",
                    target = "net/minecraft/item/Item.<init> (Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0

            )
    )

    private static Item.Settings add(Item.Settings settings) {
        return settings.fireproof();
    }

}
