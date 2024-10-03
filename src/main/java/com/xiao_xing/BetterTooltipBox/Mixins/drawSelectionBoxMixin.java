package com.xiao_xing.BetterTooltipBox.Mixins;

import static com.xiao_xing.BetterTooltipBox.Config.Color_SelectionBox;
import static com.xiao_xing.BetterTooltipBox.Config.Enable_SelectionBox;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RenderGlobal.class)
public class drawSelectionBoxMixin {

    private static String hex = Color_SelectionBox;

    private static int colorHex = Integer.decode(hex);

    @Redirect(
        method = "drawSelectionBox",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/RenderGlobal;drawOutlinedBoundingBox(Lnet/minecraft/util/AxisAlignedBB;I)V"))
    public void drawOutlinedBoundingBox(AxisAlignedBB p_147590_0_, int p_147590_1_) {
        if (Enable_SelectionBox) {
            RenderGlobal.drawOutlinedBoundingBox(p_147590_0_, colorHex);
        }
        RenderGlobal.drawOutlinedBoundingBox(p_147590_0_, p_147590_1_);
    }
}
