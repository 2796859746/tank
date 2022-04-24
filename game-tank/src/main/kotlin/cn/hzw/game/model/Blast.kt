package cn.hzw.game.model

import cn.hzw.game.Config
import cn.hzw.game.business.Destroyable
import org.itheima.kotlin.game.core.Painter

/**
 * @program: game-tank
 *
 * @description 爆炸物
 *
 * @author: wuying
 * @create: 2022-04-23 13:53
 **/
class Blast(override val x: Int, override val y: Int) : Destroyable {

    override val width: Int = Config.block
    override val height: Int = Config.block
    private val imagePaths = arrayListOf<String>()
    private var index: Int = 0

    init {
        (1..32).forEach{
            imagePaths.add("img/blast_${it}.png")
        }
    }

    override fun draw() {
        val i = index % imagePaths.size
        Painter.drawImage(imagePaths[i],x,y)
        index ++
    }

    override fun isDestroyed(): Boolean {
        return index > imagePaths.size
    }
}