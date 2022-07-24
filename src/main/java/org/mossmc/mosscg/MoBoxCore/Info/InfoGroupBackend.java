package org.mossmc.mosscg.MoBoxCore.Info;

import org.mossmc.mosscg.MoBoxCore.Main;

public class InfoGroupBackend {
    public static void sendPluginStartGroup(String name,String version) {
        Main.logger.info("==========================");
        Main.logger.info("欢迎使用MoBox系列插件");
        Main.logger.info("插件名称："+name);
        Main.logger.info("插件版本："+version);
        Main.logger.info("==========================");
    }
}
