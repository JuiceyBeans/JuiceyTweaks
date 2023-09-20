package com.juicey.juiceytweaks.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "juiceytweaks")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    public static ModConfig INSTANCE;

    public static void init() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @ConfigEntry.Gui.Tooltip()
    public boolean enableTorchflower = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean enableCookieRework = false;

    @ConfigEntry.Gui.Tooltip()
    public boolean enableFreezingSnowballs = true;

    @ConfigEntry.Gui.Tooltip()
    public boolean enableSculkParticles = true;
}
