package org.multicoder.nlti.mixins;


import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
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

@Mixin(BedBlock.class)
public class BedBound
{
    @Inject(at = @At("HEAD"), method = "onUse",cancellable = true)
    private void init(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir)
    {
        if(!world.isClient())
        {
            if(!NLTI.Vars.CanSleep)
            {
                player.sendMessage(Text.literal("Can't Sleep"));
                cir.setReturnValue(ActionResult.CONSUME);
                cir.cancel();
            }
            else{
                player.sendMessage(Text.literal("Can Sleep"));
            }
        }
    }
}
