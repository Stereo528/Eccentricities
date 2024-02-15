package dev.stereo528.eccentricities.blocks;

import com.google.common.collect.BiMap;
import dev.stereo528.eccentricities.Eccentricities;
import dev.stereo528.eccentricities.util.EccentricitiesBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class CopperFireBlock extends BaseFireBlock {


	public CopperFireBlock(Properties properties) {
		super(properties, 2.0f);
	}

	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
		Eccentricities.LOGGER.info("shape");
		return this.canSurvive(blockState, levelAccessor, blockPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
	}

	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//		boolean bl2 = level.getBiome(pos).is(BiomeTags.INCREASED_FIRE_BURNOUT);
//		int k = bl2 ? -50 : 0;
//		this.checkBurnOut(level, pos.east(), 300 + k, random);
//		this.checkBurnOut(level, pos.west(), 300 + k, random);
//		this.checkBurnOut(level, pos.below(), 250 + k, random);
//		this.checkBurnOut(level, pos.above(), 250 + k, random);
//		this.checkBurnOut(level, pos.north(), 300 + k, random);
//		this.checkBurnOut(level, pos.south(), 300 + k, random);
		Eccentricities.LOGGER.info("tick");

		Optional<BlockState> Oxidization = WeatheringCopper.getPrevious(state);
		Optional<BlockState> Wax = Optional.ofNullable((Block)((BiMap)HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(state.getBlock())).map((block) -> {
			return block.withPropertiesOf(state);
		});
		if (random.nextInt(100) <= 60 && (!level.isRaining() || !this.isNearRain(level, pos))) {
			Eccentricities.LOGGER.info("random");
			if (Wax.isPresent()) {
				level.setBlock(pos.below(), (BlockState)Wax.get(), 11);
			} else Oxidization.ifPresent(state2 -> level.setBlock(pos.below(), (BlockState) state2, 11));
		}
	}

	protected boolean isNearRain(Level level, BlockPos pos) {
		Eccentricities.LOGGER.info("near rain");
		return level.isRainingAt(pos) || level.isRainingAt(pos.west()) || level.isRainingAt(pos.east()) || level.isRainingAt(pos.north()) || level.isRainingAt(pos.south());
	}

	private void checkBurnOut(Level level, BlockPos pos, int chance, RandomSource random) {
		BlockState blockState = level.getBlockState(pos);
		Optional<BlockState> Oxidization = WeatheringCopper.getPrevious(blockState);
		Optional<BlockState> Wax = Optional.ofNullable((Block)((BiMap)HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(blockState.getBlock())).map((block) -> {
			return block.withPropertiesOf(blockState);
		});

		if (random.nextInt(chance) < 20) {
			if(!level.isRainingAt(pos)){
				if (Wax.isPresent()) {
					level.setBlock(pos, (BlockState)Wax.get(), 11);
				} else Oxidization.ifPresent(state -> level.setBlock(pos, (BlockState) state, 11));
			}
		}
	}

	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		Eccentricities.LOGGER.info("survive");
		return canSurviveOnBlock(levelReader.getBlockState(blockPos.below()));
	}

	public static boolean canSurviveOnBlock(BlockState blockState) {
		Eccentricities.LOGGER.info("survive on block");
		return blockState.is(EccentricitiesBlockTags.COPPER_FIRE_BASE_BLOCKS);
	}

	protected boolean canBurn(BlockState blockState) {
		Eccentricities.LOGGER.info("burn");
		return true;
	}

}
