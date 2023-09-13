package com.juicey.juiceytweaks.mixin;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {

    //Mixin config adapted from BedrockIfy (https://github.com/juancarloscp52/BedrockIfy)
    @Override
    public void onLoad(String mixinPackage) {
        MixinFeatureManager.loadMixinSettings();
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if(mixinClassName.equals("com.juicey.juiceytweaks.mixin.TorchflowerGlowMixin") && FabricLoader.getInstance().isModLoaded("glowing-torchflower")) {
            LogManager.getLogger().info("Glowing Torchflower was detected, disabling torchflower glow from Juicey's Tweaks");
            return false;
        }
        return MixinFeatureManager.isFeatureEnabled(mixinClassName);
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
