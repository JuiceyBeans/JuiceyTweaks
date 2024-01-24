package com.juicey.juiceytweaks;

import com.juicey.juiceytweaks.config.ModConfig;
import com.juicey.juiceytweaks.item.ModItemGroup;
import com.juicey.juiceytweaks.item.ModItems;
import com.juicey.juiceytweaks.mixin.MixinPlugin;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuiceyTweaks implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("juiceytweaks");
	public static final String MOD_ID = "juiceytweaks";

	public static boolean powderSnowWalkCondition(Entity entity) {
        if(EnchantmentHelper.getEquipmentLevel(Enchantments.FROST_WALKER, ((LivingEntity)entity)) > 0) {
			return true;
		} else return false;
    };

	@Override
	public void onInitialize() {
		LOGGER.info("[Juicey's Tweaks] Beginning initialisation (beep boop boop beep)");
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
