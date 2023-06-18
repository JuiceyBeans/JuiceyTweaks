package com.juicey.jtweaks.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Blocks.class)
public class TorchflowerGlow {
	@ModifyArg(method = "<clinit>",
			slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=torchflower")),
			at = @At(value = "INVOKE", target = "net/minecraft/block/Block.<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V", ordinal = 0),
			index = 0)
	private static AbstractBlock.Settings modify(AbstractBlock.Settings settings) {
		return settings.luminance(state -> 15);
	}
}