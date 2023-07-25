package com.juicey.jtweaks;

import com.juicey.jtweaks.item.ModItemGroup;
import com.juicey.jtweaks.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
	}
}