package org.mossmc.mosscg.MoBoxCore.Game;

import java.lang.reflect.Method;

public interface Game {
    /**
     * 这里是游戏初始化所需要的一些内容
     * 初始化后不可更改的常量
     * 可更改的在GameBasicInfo类里头
     * 具体功能及作用会在下面有写
     */

    //开局前等待时间
    int waitTime();
    //到期后减少到的时间
    int reduceTime();
    //最少开局玩家数
    int minPlayer();
    //玩家上限
    int maxPlayer();

    //小游戏名称，如Hunter
    String gameName();
    //小游戏短名称，如Hunter
    String gameShortName();
    //结束后跳转到的下一个服务器
    String gameServerNext();
    //结束后跳转到的大厅
    String gameServerLobby();

    //游戏结束后是否要跳转到下一局游戏
    boolean gameEndServerTeleport();
}
