package dev.stereo528.eccentricities.mixin;

import dev.stereo528.eccentricities.blocks.CopperFireBlock;
import dev.stereo528.eccentricities.blocks.EccentricitiesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BaseFireBlock.class)
public class BaseFireBlockMixin {

	@Inject(method = "getState", at = @At("RETURN"), cancellable = true)
	private static void addCopperFire(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockState> cir) {
		BlockPos blockPos2 = blockPos.below();
		BlockState blockState = blockGetter.getBlockState(blockPos2);
		if(SoulFireBlock.canSurviveOnBlock(blockState)) { cir.setReturnValue(Blocks.SOUL_FIRE.defaultBlockState()); }
		else if (CopperFireBlock.canSurviveOnBlock(blockState)) { cir.setReturnValue(EccentricitiesBlocks.COPPER_FIRE.defaultBlockState());}
		else cir.setReturnValue(((FireBlock)Blocks.FIRE).getStateForPlacement(blockGetter, blockPos));
	}
}
