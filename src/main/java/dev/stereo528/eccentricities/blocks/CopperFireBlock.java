package dev.stereo528.eccentricities.blocks;

import dev.stereo528.eccentricities.util.EccentricitiesBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CopperFireBlock extends BaseFireBlock {
	public CopperFireBlock(Properties properties) {
		super(properties, 2.0f);
	}

	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
		return this.canSurvive(blockState, levelAccessor, blockPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
	}

	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		return canSurviveOnBlock(levelReader.getBlockState(blockPos.below()));
	}

	public static boolean canSurviveOnBlock(BlockState blockState) {
		return blockState.is(EccentricitiesBlockTags.COPPER_FIRE_BASE_BLOCKS);
	}

	protected boolean canBurn(BlockState blockState) {
		return true;
	}

}
