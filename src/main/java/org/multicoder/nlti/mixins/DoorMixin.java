package org.multicoder.nlti.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DoorBlock.class)
public class DoorMixin
{
    @Inject(at = @At("HEAD"), method = "onUse",cancellable = true)
    public void init(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir){
        if(!world.isClient())
        {
            if(!NLTI.Vars.Doors)
            {
                player.sendMessage(Text.literal("You Cannot Do That Right Now"));
                cir.setReturnValue(ActionResult.CONSUME);
                cir.cancel();
            }
        }
    }
}
