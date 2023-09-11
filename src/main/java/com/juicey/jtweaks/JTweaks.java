package com.juicey.jtweaks;

import com.juicey.jtweaks.item.ModItemGroup;
import com.juicey.jtweaks.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JTweaks implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("jtweaks");
	public static final String MOD_ID = "jtweaks";

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from JuiceyTweaks! Beginning initialisation (beep boop boop beep)");
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();

		// Smelts 128 items
		// Would've done 512, but fuelTime is a short apparently so it might cause chunk saving errors
		// Why so long? I guess to get around the non-stackable limit of the lava bucket lol
		// You could smelt a whole lotta things like this. Full stack would smelt 128 stacks of items
		// No idea why the hell you'd need to smelt that much lmao
		FuelRegistry.INSTANCE.add(Items.DIAMOND, 25600);
	}
}
