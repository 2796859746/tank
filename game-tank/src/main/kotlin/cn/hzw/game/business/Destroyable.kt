package cn.hzw.game.business

import cn.hzw.game.model.View

/**
 * @program: game-tank
 *
 * @description 销毁的能力
 *
 * @author: wuying
 * @create: 2022-04-20 21:52
 **/
interface Destroyable : View{

    /**
     * 判断是否销毁了
     */
    fun isDestroyed():Boolean

    /**
     * 死给你看的功能
     */
    fun showDestroy():Array<View>?{
        return null
    }
}