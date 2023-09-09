package com.juicey.jtweaks.access;

import net.minecraft.block.BlockState;

import static net.minecraft.block.PitcherCropBlock.AGE;

public interface PitcherCropBlockAccess {
    BlockState JuiceyTweaks$withMaxAge(BlockState blockState);
}
