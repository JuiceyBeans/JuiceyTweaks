package com.juicey.juiceytweaks;

import com.juicey.juiceytweaks.item.ModItemGroup;
import com.juicey.juiceytweaks.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuiceyTweaks implements ModInitializer {

	// Hello!
	// If you're reading my code for some reason, please keep in mind that I make Minecraft mods as a hobby lol
	// These mods are mainly made for me and my friends first, public distribution comes second
	// So a lot of the code here is probably WILDLY unoptimized or just plain stupid
	// Juicey's Tweaks is my first mod so a lot of things are going to be wonky!
	// If I ever have the time or motivation to come back to it when I have more experience, I'll try to fix a lot of things that are wrong with it!
	// Lastly, CONSTRUCTIVE criticism would be appreciated instead of simply calling me dumb for how my code is written :)
	// Cheers, KarthiBeans

    public static final Logger LOGGER = LoggerFactory.getLogger("juiceytweaks");
	public static final String MOD_ID = "juiceytweaks";


	@Override
	public void onInitialize() {
		LOGGER.info("[Juicey's Tweaks] Beginning initialisation (beep boop boop beep)");
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
		FuelRegistry.INSTANCE.add(Items.DIAMOND, 25600);
	}

	public static void addVisualitySparkle(World world, double x, double y, double z) {
		world.addParticle(visuality.registry.VisualityParticles.SPARKLE, x + 0.5, y + 0.5, z + 0.5, 0, 0, 0);
	}
}
