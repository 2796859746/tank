package cn.hzw.game.model

import cn.hzw.game.Config
import cn.hzw.game.business.Attackable
import cn.hzw.game.business.Blockable
import cn.hzw.game.business.Sufferable
import org.itheima.kotlin.game.core.Painter

/**
 * @program: game-tank
 *
 * @description 铁墙
 * 具有阻塞功能
 * 具有接受攻击功能
 * @author: wuying
 * @create: 2022-04-18 19:47
 **/
class Steel(override val x: Int, override val y: Int) : Blockable,Sufferable{
    override val blood: Int = 1

    //位置
//    override val x: Int = 300
//    override val y: Int = 300
    //宽高
    override val width: Int = Config.block
    override val height: Int = Config.block

    //显示行为
    override fun draw() {
        Painter.drawImage("img/steel.gif",x,y)
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        return null
    }
}