package cn.hzw.game.business

import cn.hzw.game.model.View

/**
 * @program: game-tank
 *
 * @description 自动射击的功能
 *
 * @author: wuying
 * @create: 2022-04-24 00:56
 **/
interface AutoShot {
    /**
     * 自动射击的功能
     */
    fun autoShot(): View?
}