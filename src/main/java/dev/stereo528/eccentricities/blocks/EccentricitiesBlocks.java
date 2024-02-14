package dev.stereo528.eccentricities.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static dev.stereo528.eccentricities.Eccentricities.MODID;
import static net.minecraft.world.level.block.Blocks.STONE;

public class EccentricitiesBlocks {

	public static final Block MARBLE_BLOCK = register("marble", new Block(BlockBehaviour.Properties.copy(STONE)));
	public static final Block SODALITE_BLOCK = register("sodalite", new Block(BlockBehaviour.Properties.copy(STONE)));
	public static final Block OLIVINE_BLOCK = register("olivine", new Block(BlockBehaviour.Properties.copy(STONE)));

	public static final Block COPPER_FIRE = register("copper_fire", new FireBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).replaceable().noCollission().instabreak().lightLevel((blockStatex) -> {
		return 15;
	}).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
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
