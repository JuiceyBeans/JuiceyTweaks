package com.juicey.juiceytweaks.mixin;

import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkCatalystBlock.class)
public abstract class SculkCatalystMixin extends BlockWithEntity {
    public SculkCatalystMixin(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(AbstractBlock.Settings settings, CallbackInfo ci) {
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if(state.getBlock() instanceof SculkCatalystBlock && random.nextFloat() > 0.5) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();

            if (random.nextFloat() > 0.8) {
                world.addParticle(ParticleTypes.SCULK_CHARGE_POP, x + 0.5, y + 0.5, z + 0.5, 0, 0, 0);
                world.addParticle(ParticleTypes.SCULK_SOUL, x + 0.5, y + 0.5, z + 0.5, 0, 0, 0);
            }
        }

    }
}
