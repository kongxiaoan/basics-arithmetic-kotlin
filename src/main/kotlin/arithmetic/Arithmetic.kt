package arithmetic

import java.util.*

object Arithmetic {

    @JvmStatic
    fun main(args: Array<String>) {
        fibonacciTest()
    }

    private fun fibonacciTest() {
        var time = 0
        println("递推兔子产崽问题")
        println("请输入时间 ")
        val scanner = Scanner(System.`in`)
        time = scanner.nextInt()
        var result = fibonacci(time)
        println("$time 月后，产仔 = $result 对")
    }

    /**
     * 递推算法
     * 如果一对两个月大的兔子以后每一个月都可以生一对小兔子，
     * 而一对新生的兔子出生两个月后才可以生小兔子。也就是说，
     * 1月份出生，3月份才可产仔。那么假定一年内没有发生兔子死亡事件，那么1年后共有多少对兔子呢？
     * 先来分析一下兔子产仔问题。逐月分析每月的兔子对数。
     * 第1个月：1对兔子；
     * 第2个月：1对兔子；
     * 第3个月：2对兔子；
     * 第4个月：3对兔子；
     * 第5个月：5对兔子；
     * 从第3个月开始，每个月的兔子总对数等于前两个月兔子数的总和
     *
     * 第n个月兔子总数Fn=Fn-2+Fn-1。
     */
    private fun fibonacci(n: Int): Int {
        var t1 = 0
        var t2 = 0
        return if (n == 1 || n == 2) {
            1
        } else {
            t1 = fibonacci(n - 1)
            t2 = fibonacci(n - 2)
            t1 + t2
        }
    }

    private fun qiongjuTest() {
        var head = 0
        var foot = 0
        println("鸡兔同笼问题、、、、、、")
        println("请输入有头多少个")
        val scanner = Scanner(System.`in`)
        head = scanner.nextInt()
        println("请输入有脚多少个")
        foot = scanner.nextInt()
        var result = qiongju(head, foot)
        if (result == 1) {
            println("鸡 = ${chichen}, 兔 = ${habbit}")
        } else {
            println("无法求解")
        }
    }

    /**
     * 今有鸡兔同笼，上有三十五头，下有九十四足，问鸡兔各几何？
     */
    private var chichen = 0
    private var habbit = 0
    private fun qiongju(head: Int, foot: Int): Int {
        var result = 0
        var j = 0
        for (i in 0..head) {
            j = head - i
            if (i * 2 + j * 4 == foot) {
                result = 1
                chichen = i
                habbit = j
            }
        }
        return result
    }
}