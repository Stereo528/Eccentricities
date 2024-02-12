package dev.stereo528.eccentricities;

import eu.midnightdust.lib.config.MidnightConfig;
import dev.stereo528.eccentricities.config.ModConfig;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import static dev.stereo528.eccentricities.Eccentricities.MODID;

public class EccentricitiesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		MidnightConfig.init(MODID, ModConfig.class);
	}
}
