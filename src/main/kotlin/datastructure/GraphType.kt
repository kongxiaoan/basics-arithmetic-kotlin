package datastructure

import java.util.Scanner

/**
 * 每个数据元素之间可以任意关联，这就构成了一个图结构
 * 顶点 Vertex 图中的数据元素
 * 边（Edge） 图中连接这些顶点的线
 * 所有的顶点构成一个顶点集合，所有的边构成边集合，一个完整的图结构由顶点集合和边集合组成
 * G=（V，E）或者 G=（V（G），E（G））
 * 其中，V（G）表示图结构中所有顶点的集合，顶点可以用不同的数字或者字母来表示。E（G）是图结构中所有边的集合，每条边由所连接的两个顶点表示
 * 图结构中顶点集合V（G）必须为非空，即必须包含一个顶点。而图结构中边集合E（G）可以为空，此时表示没有边
 *  有向：具有方向性
 *  顶点的度：Degree 无向表示顶点的连接边的数量
 *  有向：
 *  根据连接顶点V的边的方向性，一个顶点的度有入度和出度之分。
 *  ・入度是以该顶点为端点的入边数量，记为ID（V）。
 *  ・出度是以该顶点为端点的出边数量，记为OD（V）
 *  总度 = D(V) = ID(V) + OD(V)
 *  邻接顶点：邻接顶点是指图结构中一条边的两个顶点
 *  有向：入边邻接顶点，出边邻接顶点
 *  如果在一个无向图中，每两个顶点之间都存在一条边，那么这种图结构称为无向完全图
 */
const val MAX_NUM = 20 //图的最大顶点数
const val MAX_VALUE = 65535 //表示没有边的权值


class GraphType {
    //保存顶点信息
    var vertex = arrayOfNulls<Char>(MAX_NUM)

    //0 无向，1有向
    var gType: Int = 0

    //顶点数量
    var vertexNum = 0

    //边的数量
    var edgeNum = 0

    // 保存边的权
    var edgeWeight = Array(MAX_NUM) { IntArray(MAX_NUM) }

    //遍历标志
    var isTrav = arrayOfNulls<Int>(MAX_NUM)

    fun createGraph(gType: GraphType) {
        var j = 0
        var i = 0
        //权
        var weight = 0
        var eStartV: Char = '0'
        var eEndV: Char = '0'
        println("输入图中各个顶点的信息：")
        var input: Scanner = Scanner(System.`in`)
        for (i in 0 until gType.vertexNum) {
            print("第${i + 1} 个顶点")
            gType.vertex[i] = input.next().toCharArray()[0]
        }
        println("输入构成各边顶点及权值：")
        for (k in 0 until gType.edgeNum) {
            print("第${k + 1} 条边:")
            eStartV = input.next()[0]
            eEndV = input.next()[0]
            weight = input.nextInt()
            i = 0
            while (eStartV != gType.vertex[i]) {
                i++
            }
            j = 0
            while (eEndV != gType.vertex[j]) {
                j++
            }
            gType.edgeWeight[i][j] = weight
            if (gType.gType == 0) {
                //对于无向图，其邻接矩阵左下角和右上角是对称的。
                gType.edgeWeight[j][i] = weight
            }
        }

    }

    /**
     * 清空矩阵
     */
    fun clearGraph(gType: GraphType) {
        for (i in 0 until gType.vertexNum) {
            for (j in 0 until gType.vertexNum) {
                gType.edgeWeight[i][j] = MAX_VALUE
            }
        }
    }

    fun outGraph(gType: GraphType) {
        for (i in 0 until gType.vertexNum) {
            print("\t${gType.vertex[i]}")
        }
        println()
        for (i in 0 until gType.vertexNum) {
            print("${gType.vertex[i]}")
            for (j in 0 until gType.vertexNum) {
                if (gType.edgeWeight[i][j] == MAX_VALUE) {
                    print("\tZ")
                } else {
                    print("\t${gType.edgeWeight[i][j]}")
                }
            }
            println()
        }

    }

    fun deepTraOne(gType: GraphType, n: Int) {
        gType.isTrav[n] = 1
        print("-> ${gType.vertex[n]}")
        for (i in 0 until gType.vertexNum) {
            if (gType.edgeWeight[n][i] != MAX_VALUE && gType.isTrav[n] == 0) {
                print("n = $n i = $i")
                deepTraOne(gType, i)
            }
        }
    }

    fun deepTraGraph(gType: GraphType) {
        //清除顶点遍历标志
        for (i in 0 until gType.vertexNum) {
            gType.isTrav[i] = 0
        }
        print("深度优先遍历结点：")
        for (i in 0 until gType.vertexNum) {
            if (gType.isTrav[i] == 0) {
                deepTraOne(gType, i)
            }
        }
        println()
    }
}