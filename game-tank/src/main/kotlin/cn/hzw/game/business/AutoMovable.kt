package cn.hzw.game.business

import cn.hzw.game.enums.Direction
import cn.hzw.game.model.View

/**
 * @program: game-tank
 *
 * @description 自动移动的能力
 *
 * @author: wuying
 * @create: 2022-04-20 21:23
 **/
interface AutoMovable: View {
    //方向
    val currentDirection:Direction
    //速度
    val speed:Int

    fun autoMove()
}