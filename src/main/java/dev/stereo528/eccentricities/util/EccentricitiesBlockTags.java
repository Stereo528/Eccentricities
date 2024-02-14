package dev.stereo528.eccentricities.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static dev.stereo528.eccentricities.Eccentricities.MODID;

public class EccentricitiesBlockTags {
	public static final TagKey<Block> COPPER_FIRE_BASE_BLOCKS = create("copper_fire_base_blocks");

	public static void init(){}

	private static TagKey<Block> create(String name) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation(MODID, name));
	}
}
