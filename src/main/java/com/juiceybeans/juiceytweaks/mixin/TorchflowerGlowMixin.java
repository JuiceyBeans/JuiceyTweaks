package com.juiceybeans.juiceytweaks.mixin;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;

import static net.minecraft.block.Blocks.TORCHFLOWER;

@Mixin(Blocks.class)
public class TorchflowerGlowMixin {

    //Torchflowers have a light level of 15
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=torchflower"
                    )
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/FlowerBlock;<init>(Lnet/minecraft/entity/effect/StatusEffect;ILnet/minecraft/block/AbstractBlock$Settings;)V",
                    ordinal = 0
            )
    )

    private static Block.Settings alterTorchflowerSettings(AbstractBlock.Settings settings) {
        return settings.luminance(state -> 15);
    }

    //Torchflower crops have a light level of 5
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=torchflower_crop"
                    )
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/TorchflowerBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V",
                    ordinal = 0
            )
    )

    private static Block.Settings alterTorchflowerCropSettings(AbstractBlock.Settings settings) {
        return settings.luminance(state -> switch (state.get(TorchflowerBlock.AGE)) {
            case 0 -> 5;
            case 1 -> 10;
            default -> 15;
        });
    }

   //Torchflowers in pots have a light level of 13
    @ModifyVariable(
            method = "createFlowerPotBlock(Lnet/minecraft/block/Block;[Lnet/minecraft/resource/featuretoggle/FeatureFlag;)Lnet/minecraft/block/FlowerPotBlock;",
            at = @At(
                    value = "STORE",
                    target = "Lnet/minecraft/block/FlowerPotBlock;<init>(Lnet/minecraft/block/Block;Lnet/minecraft/block/AbstractBlock$Settings;)V",
                    ordinal = 0
            )
    )

    private static Block.Settings alterTorchflowerPotSettings(AbstractBlock.Settings settings, Block flower) {
        if (flower == TORCHFLOWER) {
            return settings.luminance(state -> 13);
        };
        return settings;
    }
}