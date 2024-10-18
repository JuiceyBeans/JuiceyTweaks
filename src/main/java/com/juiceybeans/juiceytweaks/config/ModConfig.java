package com.juiceybeans.juiceytweaks.config;

import com.juiceybeans.juiceytweaks.JuiceyTweaks;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = JuiceyTweaks.MOD_ID)
public class ModConfig {
    public static ModConfig INSTANCE;
    private static final Object LOCK = new Object();


    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(ModConfig.class, ConfigFormats.yaml()).getConfigInstance();
            }
        }
    }
    @Configurable
    @Configurable.Synchronized
    @Configurable.Comment({"Enable glowing torchflowers (default: true)"})
    public boolean enableTorchflowerGlow = true;

    @Configurable
    @Configurable.Synchronized
    @Configurable.Comment({"Enable freezing snowballs (default: true)"})
    public boolean enableFreezingSnowballs = true;

    @Configurable
    @Configurable.Comment({"Enable sculk particles (default: true)"})
    public boolean enableSculkParticles = true;

    @Configurable
    @Configurable.Comment({"Enable walking on powdered snow with Frost Walker boots (default: true)"})
    public boolean enableFrostWalkerPowderedSnow = true;

    @Configurable
    @Configurable.Comment({"Enable fire resistant blaze rods/powder (default: true)"})
    public boolean enableFireResistantBlazeRod = true;
}
