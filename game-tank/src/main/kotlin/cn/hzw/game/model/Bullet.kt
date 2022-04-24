package cn.hzw.game.model

import cn.hzw.game.Config
import cn.hzw.game.business.Attackable
import cn.hzw.game.business.AutoMovable
import cn.hzw.game.business.Destroyable
import cn.hzw.game.business.Sufferable
import cn.hzw.game.enums.Direction
import cn.hzw.game.ext.checkCollision
import org.itheima.kotlin.game.core.Painter

/**
 * @program: game-tank
 *
 * @description 子弹
 * create()函数返回两个值，是x，y
 * @author: wuying
 * @create: 2022-04-19 22:20
 **/
class Bullet(
    override val owner: View,override val currentDirection: Direction, create:(width:Int, height:Int)->Pair<Int,Int>) :
    AutoMovable,Destroyable,Attackable,Sufferable {
    //给子弹一个方向，方向由坦克来决定
    override val width: Int
    override val height: Int
    override val blood: Int = 1

    override var x: Int = 0
    override var y: Int = 0

    private var isDestoyed = false

    override val attackPower: Int = 1


    private val imagePath:String = when(currentDirection){
        Direction.UP -> "img/shot_top.gif"
        Direction.DOWN -> "img/shot_bottom.gif"
        Direction.LEFT -> "img/shot_left.gif"
        Direction.RIGHT -> "img/shot_right.gif"
    }

    init {
        //先计算宽度和高度
        val size = Painter.size(imagePath)
        width = size[0]
        height = size[1]

        val pair = create.invoke(width,height)
        x = pair.first
        y = pair.second
    }

    override fun draw() {
        Painter.drawImage(imagePath,x,y)
    }

    override val speed: Int = 8

    override fun autoMove() {

        //根据自己的方向，来改变x和y
        when(currentDirection){
            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed
        }
    }

    override fun isDestroyed(): Boolean {
        if (isDestoyed) return true

        //子弹在脱离了屏幕后，需要被销毁
        if (x < -width) return true
        if (x > Config.gameWidth) return true
        if (y < -height) return true
        if (y > Config.gameHeight) return true
        return false
    }


    override fun isCollision(sufferable: Sufferable): Boolean {
        return checkCollision(sufferable)
    }

    override fun notifyAttack(sufferable: Sufferable) {
//        println("子弹接收到碰撞了..")
        //子弹打到墙上后，子弹要销毁掉
        isDestoyed = true
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        return arrayOf(Blast(x,y))
    }
}