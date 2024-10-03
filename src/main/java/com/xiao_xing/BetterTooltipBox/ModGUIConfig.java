package com.xiao_xing.BetterTooltipBox;

import static com.xiao_xing.BetterTooltipBox.Config.getConfigFile;
import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import cpw.mods.fml.client.config.GuiConfig;

public class ModGUIConfig extends GuiConfig {

    public ModGUIConfig(GuiScreen guiScreen) {
        super(
            guiScreen,
            new ConfigElement(getConfigFile().getCategory(CATEGORY_GENERAL)).getChildElements(),
            BetterTooltipBox.MODID,
            false,
            false,
            GuiConfig.getAbridgedConfigPath(getConfigFile().toString()));
    }
}
