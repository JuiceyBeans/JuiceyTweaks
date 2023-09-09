package com.juicey.jtweaks.mixin;

import com.juicey.jtweaks.access.PitcherCropBlockAccess;
import net.minecraft.block.BlockState;
import net.minecraft.block.PitcherCropBlock;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.block.PitcherCropBlock.AGE;

@Mixin(PitcherCropBlock.class)
public class PitcherMaxAgeMixin implements PitcherCropBlockAccess {
    @Override
    public BlockState JuiceyTweaks$withMaxAge(BlockState blockState) {
        return blockState.with(AGE, 4);
    }
}
