package datastructure

// 顺序表最大长度
const val MAXLEN = 100

//结点数据
data class Data(val key: String, val name: String, val age: Int)

// 顺序表结构
class SlType {
    private var listData = arrayOfNulls<Data>(MAXLEN + 1) //顺序表数据结构
    private var listLen = 0 //顺序表已存结点的数量


    // 初始化顺序表
    constructor(slType: SlType) {
        slType.listLen = 0
    }

    /**
     * 获取线性表的长度
     */
    fun getSLLength(slType: SlType) = slType.listLen

    fun insertSL(slType: SlType, n: Int, data: Data): Int {
        if (slType.listLen >= MAXLEN) {
            println("顺序表已满")
            return 0
        }
        if (n < 1 || n > slType.listLen - 1) {
            println("插入元素的序号错误")
            return 0
        }
        var i = slType.listLen
        while (i >= n) {
            slType.listData[i + 1] = slType.listData[i]
            i--
        }
        slType.listData[n] = data
        slType.listLen++
        return 1
    }

    /**
     * 追加结点
     */
    fun addSL(slType: SlType,data: Data) :Int{
        if(slType.listLen >= MAXLEN) {
            println("顺序表已满")
            return 0
        }
        slType.listData[++slType.listLen] = data
        return 1
    }
}