package arithmetic

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
object FibonacciArithmetic {

    @JvmStatic
    fun main(args: Array<String>) {

    }
}