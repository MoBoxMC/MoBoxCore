package org.mossmc.mosscg.MoBoxCore.Game;

import java.lang.reflect.Method;

public class GameBasicInfo {
    //如果需要使用Game模块必须要初始化的内容
    public static Game getGame;

    public static GameStatus.gameStatus gameStatus = GameStatus.gameStatus.Waiting;


    //StepStarting方法，用于倒计时结束时调用
    public static Method startMethod = null;
    //StepRunning方法，用于开局前准备工作完成后调用
    public static Method runMethod = null;
}
