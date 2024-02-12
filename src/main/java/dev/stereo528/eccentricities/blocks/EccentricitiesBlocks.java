package dev.stereo528.eccentricities.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static dev.stereo528.eccentricities.Eccentricities.MODID;
import static net.minecraft.world.level.block.Blocks.STONE;

public class EccentricitiesBlocks {

	public static final Block MARBLE_BLOCK = register("marble", new Block(BlockBehaviour.Properties.copy(STONE)));

	private static Block register(String name, Block block) {
		BlockItem item = new BlockItem(block, new QuiltItemSettings());
//		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
//			content.accept(item);
//		});
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name), block);
	}
	public static void init(){}
}
