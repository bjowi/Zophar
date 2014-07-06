package bjowi.mods.zophar;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

/**
 * Created by mods on 2014-06-24.
 */
@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION,
        guiFactory = Constants.MOD_CONFIG_GUI_FACTORY)
public class Zophar {

    @Mod.Instance(Constants.MOD_ID)
    public static Zophar instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        FMLLog.log(Constants.MOD_ID, Level.INFO, "Whee");
        ModConfig.init(e.getSuggestedConfigurationFile());
        ModConfig.syncConfig();
        FMLLog.log(Constants.MOD_ID, Level.INFO, e.getSuggestedConfigurationFile().getAbsolutePath());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(instance);
      }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.modID.equals(Constants.MOD_ID)) {
            ModConfig.syncConfig();
        }
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    }


}