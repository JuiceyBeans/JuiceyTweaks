package com.juiceybeans.juiceytweaks.mixin;

import com.juiceybeans.juiceytweaks.config.ModConfig;
import com.juiceybeans.juiceytweaks.integration.VisualityIntegration;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CalibratedSculkSensorBlock.class)
public abstract class SculkCalibratedMixin extends SculkSensorBlock {
    public SculkCalibratedMixin(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(AbstractBlock.Settings settings, CallbackInfo ci) {
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (ModConfig.INSTANCE != null && ModConfig.INSTANCE.enableSculkParticles) {
            super.randomDisplayTick(state, world, pos, random);
            if(state.getBlock() instanceof CalibratedSculkSensorBlock && random.nextFloat() > 0.5) {
                double x = pos.getX() + random.nextDouble();
                double y = pos.getY() + random.nextDouble();
                double z = pos.getZ() + random.nextDouble();

                if (random.nextFloat() > 0.85) {
                    world.addParticle(ParticleTypes.SCULK_CHARGE_POP, x + 0.5, y + 0.5, z + 0.5, 0, 0, 0);
                }
                if (random.nextFloat() > 0.95 && FabricLoader.getInstance().isModLoaded("visuality")) {
                    VisualityIntegration.addVisualitySparkle(world, x + 0.5, y + 0.5, z + 0.5);
                }
            }
        }
    }
}
