package cn.hzw.game.business

import cn.hzw.game.model.View

/**
 * @program: game-tank
 *
 * @description 遭受攻击的接口
 *
 * @author: wuying
 * @create: 2022-04-20 22:05
 **/
interface Sufferable:View {
    /**
     * 生命值
     */
    val blood:Int

    fun notifySuffer(attackable: Attackable) : Array<View>?
}