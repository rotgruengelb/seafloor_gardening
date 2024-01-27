package net.rotgruengelb.seafloor_gardening.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpreadableBlock.class)
public class SpreadableBlockMixin {

	@Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
	private static void canSurvive(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockPos blockPos = pos.up();
		if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
			cir.setReturnValue(true);
		}
	}

	@Inject(method = "canSpread", at = @At("HEAD"), cancellable = true)
	private static void canSpread(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		BlockPos blockPos = pos.up();
		if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
			cir.setReturnValue(true);
		}
	}
}
