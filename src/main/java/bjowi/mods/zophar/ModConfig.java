package bjowi.mods.zophar;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by mods on 2014-07-05.
 */
public class ModConfig {
    public static Configuration config;

    public static int myConfigInteger = 32;
    public static String myConfigString = "Hello!";
    public static boolean myConfigBool = false;

    public static void syncConfig() {
        myConfigInteger = config.getInt("My Config Integer", Configuration.CATEGORY_GENERAL, myConfigInteger, 0, Integer.MAX_VALUE, "An Integer!");
        myConfigString = config.getString("My Config String", Configuration.CATEGORY_GENERAL, myConfigString, "A String!");
        myConfigBool = config.getBoolean("My Config Bool", Configuration.CATEGORY_GENERAL, myConfigBool, "A Boolean!");

        if(config.hasChanged())
            config.save();
    }

    public static void init(File configFile) {
        config = new Configuration(configFile);
        config.load();
    }
}
