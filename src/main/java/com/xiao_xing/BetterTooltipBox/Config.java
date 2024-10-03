package com.xiao_xing.BetterTooltipBox;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Config {

    public static Configuration configFile;

    public static boolean Enable_BetterTooltipBox = true;
    public static boolean Enable_SelectionBox = true;
    public static String Color_Background = "0x3591db";
    public static String Color_SelectionBox = "0x3591db";
    public static String Color_Name = "WHITE";

    public static void init(String configDir) {
        if (configFile == null) {
            File path = new File(configDir + "/" + BetterTooltipBox.MODID + ".cfg");
            configFile = new Configuration(path);
            synchronizeConfiguration();
        }

    }

    public static void synchronizeConfiguration() {
        Enable_BetterTooltipBox = configFile
            .getBoolean("Enable BetterTooltipBox", Configuration.CATEGORY_GENERAL, true, "Enable BetterTooltipBox");

        Enable_SelectionBox = configFile
            .getBoolean("Enable SelectionBox", Configuration.CATEGORY_GENERAL, true, "Enable SelectionBox");

        Color_Background = configFile.getString(
            "Change Background color RGB ",
            Configuration.CATEGORY_GENERAL,
            "0x3591db",
            "Change Background color RGB ");

        Color_Name = configFile
            .getString("Change Name color ", Configuration.CATEGORY_GENERAL, "WHITE", "Change Name color ");

        Color_SelectionBox = configFile.getString(
            "Change SelectionBox Color RGB ",
            Configuration.CATEGORY_GENERAL,
            "0x000000",
            "Change Selection Color RGB ");

        if (configFile.hasChanged()) {
            configFile.save();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(BetterTooltipBox.MODID)) {
            synchronizeConfiguration();
        }
    }

    public static Configuration getConfigFile() {
        return configFile;
    }
}
