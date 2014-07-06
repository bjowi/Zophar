package bjowi.mods.zophar;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.Set;

/**
 * Created by mods on 2014-07-05.
 */
public class ConfigGuiFactory implements IModGuiFactory {

    @Override
    public void initialize(Minecraft minecraftInstance) {}

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return ConfigGuiScreen.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }

    public static class ConfigGuiScreen extends GuiConfig {
        public ConfigGuiScreen(GuiScreen parentScreen) {
            super(parentScreen,
                  new ConfigElement(ModConfig.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                  Constants.MOD_ID,
                  false, false, GuiConfig.getAbridgedConfigPath(ModConfig.config.toString()));
        }
    }
}

