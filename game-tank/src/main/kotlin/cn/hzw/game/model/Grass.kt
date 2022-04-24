package cn.hzw.game.model

import cn.hzw.game.Config
import org.itheima.kotlin.game.core.Painter

/**
 * @program: game-tank
 *
 * @description 草坪
 *
 * @author: wuying
 * @create: 2022-04-18 19:47
 **/
class Grass(override val x: Int, override val y: Int) : View{
    //位置
//    override val x: Int = 200
//    override val y: Int = 200
    //宽高
    override val width: Int = Config.block
    override val height: Int = Config.block

    //显示行为
    override fun draw() {
        Painter.drawImage("img/grass.gif",x,y)
    }
}