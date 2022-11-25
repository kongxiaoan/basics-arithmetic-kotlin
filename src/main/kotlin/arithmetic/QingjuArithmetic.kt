package arithmetic

import java.util.Scanner

/**
 * 穷举算法
 * 今有鸡兔同笼，上有三十五头，下有九十四足，问鸡兔各几何？
 */
object QingjuArithmetic {
    private var chichen = 0
    private var habbit = 0

    private fun qiongju(head: Int, foot: Int): Int {
        var result = 0
        var j = 0
        for (i in 0..head) {
            j = head - i
            if(i * 2 + j * 4 == foot) {
                result = 1
                chichen = i
                habbit = j
            }
        }
        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var head = 0
        var foot = 0
        println("鸡兔同笼问题、、、、、、")
        println("请输入有头多少个")
        val scanner = Scanner(System.`in`)
        head = scanner.nextInt()
        println("请输入有脚多少个")
        foot = scanner.nextInt()
        var result = qiongju(head, foot)
        if(result == 1) {
            println("鸡 = $chichen, 兔 = $habbit")
        } else {
            println("无法求解")
        }
    }


}