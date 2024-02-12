package dev.stereo528.eccentricities;

import dev.stereo528.eccentricities.blocks.EccentricitiesBlocks;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eccentricities implements ModInitializer {
	public static final String MODID = "eccentricities";
	public static final Logger LOGGER = LoggerFactory.getLogger("Eccentricities");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello world from {}!", mod.metadata().name());
		EccentricitiesBlocks.init();
	}
}
