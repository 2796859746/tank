package cn.hzw.game.ext

import cn.hzw.game.model.View

/**
 * @program: game-tank
 *
 * @description
 *
 * @author: wuying
 * @create: 2022-04-20 22:26
 **/
fun View.checkCollision(view: View):Boolean{
    return checkCollision(x,y,width,height,view.x,view.y,view.width,view.height)
}