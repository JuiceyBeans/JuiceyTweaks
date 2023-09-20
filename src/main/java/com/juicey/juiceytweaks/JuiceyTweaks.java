package com.juicey.juiceytweaks;

import com.juicey.juiceytweaks.config.ModConfig;
import com.juicey.juiceytweaks.item.ModItemGroup;
import com.juicey.juiceytweaks.item.ModItems;
import com.juicey.juiceytweaks.mixin.MixinPlugin;
import com.juicey.juiceytweaks.mixin.SculkCalibratedMixin;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuiceyTweaks implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("juiceytweaks");
	public static final String MOD_ID = "juiceytweaks";

	@Override
	public void onInitialize() {
		LOGGER.info("[JuiceyTweaks] Beginning initialisation (beep boop boop beep)");
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
		FuelRegistry.INSTANCE.add(Items.DIAMOND, 25600);
		ModConfig.init();
		MixinPlugin.init();
	}

	public static void addVisualitySparkle(World world, double x, double y, double z) {
		world.addParticle(visuality.registry.VisualityParticles.SPARKLE, x + 0.5, y + 0.5, z + 0.5, 0, 0, 0);
	}
}
