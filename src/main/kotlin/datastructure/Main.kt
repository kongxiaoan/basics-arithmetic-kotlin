package datastructure

import java.util.Scanner

object Main {

    var input = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
//        graphTest()
        treeTest()
    }

    private fun treeTest() {
        var root: GBTType? = null
        var menusel = 0
        var gbTest = GBTest()
        root = gbTest.initTree()
        do {
            println("请选择菜单添加二叉树的结点：")
            println("0. 退出")
            println("1. 添加二叉树的结点")
            menusel = input.nextInt()
            when (menusel) {
                1 -> {
                    gbTest.addTreeNode(root)
                }
            }
        } while (menusel != 0)

        //basics-arithmetic-kotlin
        do {
            println("请选择菜单遍历二叉树的结点(0.退出)：")
            println("1. 先序")
            println("2. 中序")
            println("3. 后序")
            println("4. 按层")
            menusel = input.nextInt()
            when (menusel) {
                1 -> {
                    print("先序结果：")
                    gbTest.dlrTree(root)
                    println()
                }

                2 -> {
                    print("中序结果：")
                    gbTest.ldrTree(root)
                    println()
                }

                3 -> {
                    print("后序结果：")
                    gbTest.rdlTree(root)
                    println()
                }
                4 -> {
                    print("按层结果：")
                    gbTest.levelTree(root)
                    println()
                }
            }
        } while (menusel != 0)
        println("二叉树深度为：${gbTest.treeDepth(root)}")
        gbTest.clearTree(root)
        root = null

    }

    private fun graphTest() {
        var graphType = GraphType()
        println("输入生成图的类型：")
        graphType.gType = input.nextInt()
        println("输入图的顶点数量：")
        graphType.vertexNum = input.nextInt()
        println("输入图的边数量：")
        graphType.edgeNum = input.nextInt()
        graphType.clearGraph(graphType)
        graphType.createGraph(graphType)
        println("该图的邻接矩阵数据如下：")
        graphType.outGraph(graphType)
        graphType.deepTraGraph(graphType)
    }
}