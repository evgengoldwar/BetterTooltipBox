package com.xiao_xing.BetterTooltipBox.Mixins;

import static codechicken.lib.gui.GuiDraw.gui;
import static com.xiao_xing.BetterTooltipBox.Config.Color_Name;

import java.awt.*;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumChatFormatting;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.xiao_xing.BetterTooltipBox.Util.TooltipHelper;

import codechicken.lib.gui.GuiDraw;

@Mixin(value = GuiDraw.class)
public class ItemTooltipMixin {

    /**
     * @author xiao_xing521
     * @reason 修改Tooltip提示框
     */

    @Overwrite(remap = false)
    public static void drawTooltipBox(int x, int y, int width, int height) {
        TooltipHelper.z = (int) gui.getZLevel();
        TooltipHelper.DrawTooltip(x, y, width, height);
    }

    @Inject(
        method = "drawMultilineTip(Lnet/minecraft/client/gui/FontRenderer;IILjava/util/List;)V",
        at = @At("HEAD"),
        remap = false)
    private static void onDrawMultilineTip(FontRenderer font, int x, int y, List<String> list, CallbackInfo ci) {
        EnumChatFormatting colorName = EnumChatFormatting.valueOf(Color_Name);

        for (int i = 0; i < 1; i++) {
            String s = list.get(i);
            list.set(i, colorName + EnumChatFormatting.getTextWithoutFormattingCodes(s));
        }
    }
}
