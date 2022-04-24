package cn.hzw.game.model

import cn.hzw.game.Config
import cn.hzw.game.business.Attackable
import cn.hzw.game.business.Blockable
import cn.hzw.game.business.Destroyable
import cn.hzw.game.business.Sufferable
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter

/**
 * @program: game-tank
 *
 * @description 砖墙
 *  具备阻塞能力
 *  具备挨打能力
 *  具备销毁能力
 * @author: wuying
 * @create: 2022-04-18 19:42
 **/
class Wall(override val x: Int, override val y: Int): Blockable,Sufferable,Destroyable{


    //位置
//    override val x: Int = 100
//    override val y: Int = 100
    //宽高
    override val width: Int = Config.block
    override val height: Int = Config.block

    //显示行为
    override fun draw() {
        Painter.drawImage("img/wall.gif",x,y)
    }

    override var blood: Int = 3

    override fun isDestroyed(): Boolean {
        return blood <= 0
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
//        println("砖墙接收到挨打了..")
        //砌墙要被销毁,砌墙掉血
        blood -= attackable.attackPower

        //喊疼
        Composer.play("snd/hit.wav")

        return arrayOf(Blast(x,y))
    }


}