package org.mossmc.mosscg.MoBoxCore;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mossmc.mosscg.MoBoxCore.Info.InfoGroupBackend;
import org.mossmc.mosscg.MoBoxCore.PlaceHolder.PlaceHolderMain;

import java.util.UUID;
import java.util.logging.Logger;

//这就是一个对于MoBox系列插件所设计的轮子
//懒得加注释了
public class Main extends JavaPlugin {
    public static Configuration getConfig;
    public static Main instance;
    public static Logger logger;
    @Override
    public void onLoad() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        logger = getLogger();
        getConfig = getConfig();
        instance = this;
    }

    @Override
    public void onEnable() {
        InfoGroupBackend.sendPluginStartGroup(BasicInfo.pluginName,BasicInfo.pluginVersion);
        Plugin pluginPlaceholderAPI = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        if (pluginPlaceholderAPI != null){
            logger.info("检测到PlaceHolderAPI插件，变量功能已启用！");
            new PlaceHolderMain().register();
        }
    }
}
