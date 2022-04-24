package cn.hzw.game.business

import cn.hzw.game.model.View

/**
 * @program: game-tank
 *
 * @description 具备攻击的能力
 *
 * @author: wuying
 * @create: 2022-04-20 22:05
 **/
interface Attackable:View {

    /**
     * 所有者
     */
    val owner: View

    /**
     * 攻击力
     */
    val attackPower:Int

    //判断是否碰撞
    fun isCollision(sufferable: Sufferable):Boolean

    fun notifyAttack(sufferable: Sufferable)
}