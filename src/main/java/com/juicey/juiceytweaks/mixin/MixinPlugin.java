package com.juicey.juiceytweaks.mixin;

import com.juicey.juiceytweaks.JuiceyTweaks;
import com.juicey.juiceytweaks.config.ModConfig;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    public static MixinPlugin INSTANCE;
    public static void init() {
        INSTANCE = new MixinPlugin();
    }

    private boolean enableTorchflowerMixin() {
        return ModConfig.INSTANCE.enableTorchflower;
    }

    private boolean enableCookieReworkMixin() {
        return ModConfig.INSTANCE.enableCookieRework;
    }

    private boolean enableFreezingSnowballsMixin() {
        return ModConfig.INSTANCE.enableFreezingSnowballs;
    }

    private boolean enableSculkParticlesMixin() {
        return ModConfig.INSTANCE.enableSculkParticles;
    }

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
//        Object[] sculkMixins = {
//                "com.juicey.juiceytweaks.mixin.SculkMixin",
//                "com.juicey.juiceytweaks.mixin.SculkCatalystMixin",
//                "com.juicey.juiceytweaks.mixin.SculkSensorMixin",
//                "com.juicey.juiceytweaks.mixin.SculkShriekerMixin",
//                "com.juicey.juiceytweaks.mixin.SculkVeinMixin",
//        };
//
//        for (Object sculkMixin : sculkMixins) {
//            if ((mixinClassName.equals(sculkMixin)) && (ModConfig.INSTANCE != null) && !ModConfig.INSTANCE.enableSculkParticles) {
//                return false;
//            }
//        }

        if(mixinClassName.equals("com.juicey.juiceytweaks.mixin.TorchflowerGlowMixin") && FabricLoader.getInstance().isModLoaded("glowing-torchflower")) {
            JuiceyTweaks.LOGGER.info("[JuiceyTweaks] Glowing Torchflower was detected, disabled glowing torchflowers");
            return false;
        }

        if(mixinClassName.equals("com.juicey.juiceytweaks.mixin.TorchflowerGlowMixin") && (ModConfig.INSTANCE != null) && !ModConfig.INSTANCE.enableTorchflower) {
            JuiceyTweaks.LOGGER.info("[JuiceyTweaks] Disabled glowing torchflowers");
            return false;
        }

        if(mixinClassName.equals("com.juicey.juiceytweaks.mixin.SnowballFreezingMixin") && (ModConfig.INSTANCE != null) && !ModConfig.INSTANCE.enableFreezingSnowballs) {
            JuiceyTweaks.LOGGER.info("[JuiceyTweaks] Disabled freezing snowballs");
            return false;
        }

        if(mixinClassName.equals("com.juicey.juiceytweaks.mixin.FoodMixin") && (ModConfig.INSTANCE != null) && !ModConfig.INSTANCE.enableCookieRework) {
            JuiceyTweaks.LOGGER.info("[JuiceyTweaks] Disabled better cookies");
            return false;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
