package cn.hzw.game.model

import cn.hzw.game.Config
import cn.hzw.game.business.Blockable
import org.itheima.kotlin.game.core.Painter

/**
 * @program: game-tank
 *
 * @description 水墙
 * 具备阻挡能力
 * @author: wuying
 * @create: 2022-04-18 19:47
 **/
class Water(override val x: Int, override val y: Int) : Blockable{
    //位置
//    override val x: Int = 400
//    override val y: Int = 400
    //宽高
    override val width: Int = Config.block
    override val height: Int = Config.block

    //显示行为
    override fun draw() {
        Painter.drawImage("img/water.gif",x,y)
    }
}