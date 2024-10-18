package com.juiceybeans.juiceytweaks.integration;

import net.minecraft.world.World;

public class VisualityIntegration {
    public static void addVisualitySparkle(World world, double x, double y, double z) {
        world.addParticle(visuality.registry.VisualityParticles.SPARKLE, x + 0.5, y + 0.5, z + 0.5, 0, 0, 0);
    }
}
