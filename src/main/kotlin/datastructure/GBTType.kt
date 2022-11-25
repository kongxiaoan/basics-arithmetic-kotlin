package datastructure

import java.util.Scanner


/**
 * 二叉树数据类型
 */
class GBTType {
    //结点类型
    var data = ""

    //左子树
    var left: GBTType? = null

    //右子树
    var right: GBTType? = null
}

class GBTest {
    private val input: Scanner = Scanner(System.`in`)

    /**
     * 初始化二叉树的根
     */
    fun initTree(): GBTType? {
        var node: GBTType = GBTType()
        if (node != null) {
            println("请先输入一个跟结点数据:")
            node.data = input.next()
            node.left = null
            node.right = null
            return if (node != null) {
                node
            } else {
                null
            }
        }
        return null
    }

    fun addTreeNode(gbtType: GBTType?) {
        var pNode: GBTType? = GBTType()
        var parent: GBTType? = null
        var data = ""
        var menusel: Int = 0

        if (pNode != null) {
            println("请先输入二叉树结点数据:")
            pNode.data = input.next()
            pNode.left = null
            pNode.right = null
            println("请先输入${pNode.data}的父结点数据:")
            data = input.next()
            parent = treeFindNode(gbtType, data)
            if (parent == null) {
                println("未找到父结点数据")
                pNode = null
                return
            }
            print("1. 添加该结点的左子树\n 2. 添加该结点的右子树 \n")
            do {
                menusel = input.nextInt()
                if (menusel == 1 || menusel == 2) {
                    if (parent == null) {
                        println("不存在父结点，请先设置父结点")
                    } else {
                        when (menusel) {
                            1 -> {
                                if (parent.left != null) {
                                    println("左子树不能为空")
                                } else {
                                    parent.left = pNode
                                }
                            }

                            2 -> {
                                if (parent.right != null) {
                                    println("右子树不能为空")
                                } else {
                                    parent.right = pNode
                                }
                            }

                            else -> {
                                println("不支持该操作")
                            }
                        }
                    }
                }

            } while (menusel != 1 && menusel != 2)
        }

    }

    private fun treeFindNode(treeNode: GBTType?, data: String?): GBTType? {
        if (treeNode == null) return null
        return if (treeNode.data == data) {
            treeNode
        } else {
            treeFindNode(treeNode.left, data) ?: treeFindNode(treeNode.right, data)
        }
    }

    fun getLeftTree(treeNode: GBTType?): GBTType? {
        if (treeNode == null) return null
        return treeNode.left
    }

    fun getRightTree(treeNode: GBTType?): GBTType? {
        if (treeNode == null) return null
        return treeNode.right
    }

    fun treeIsEmpty(treeNode: GBTType?): Boolean {
        return treeNode == null
    }

    /**
     * 计算二叉树的深度
     */
    fun treeDepth(treeNode: GBTType?): Int {
        var depLeft = 0
        var depRight = 0
        if (treeNode == null) return 0

        depLeft = treeDepth(treeNode.left)
        depRight = treeDepth(treeNode.right)
        return if (depRight > depLeft) {
            depRight + 1
        } else {
            depLeft + 1
        }
    }

    fun clearTree(treeNode: GBTType?) {
        if (treeNode != null) {
            clearTree(treeNode.left)
            clearTree(treeNode.right)
        }
    }

    fun treeNodeData(treeNode: GBTType?) {
        println(" ${treeNode?.data}")
    }

    /**
     *  按层遍历
     */
    fun levelTree(treeNode: GBTType?) {
        var p: GBTType? = null
        //定义一个顺序栈
        var q = arrayOfNulls<GBTType>(MAX_LEN)
        var head = 0
        var tail = 0
        //队首引用不为空
        if (treeNode != null) {
//            计算循环队列队尾序号
            tail = (tail + 1) % MAX_LEN
            // 将二叉树根引用引进队
            q[tail] = treeNode
        }
        // 队列不为空进行循环
        while (head != tail) {
            // 计算循环队列的队首序号
            head = (head + 1) % MAX_LEN
            //获取队首元素
            p = q[head]
            treeNodeData(p)
            //结点存在左子树
            if (p?.left != null) {
                tail = (tail + 1) % MAX_LEN
                // 左子树引进队列
                q[tail] = p.left
            }

            if (p?.right != null) {
                tail = (tail + 1) % MAX_LEN
                q[tail] = p.right
            }
        }
    }

    /**
     * 先序遍历
     */
    fun dlrTree(treeNode: GBTType?) {
        if(treeNode != null) {
            treeNodeData(treeNode)
            dlrTree(treeNode.left)
            dlrTree(treeNode.right)
        }
    }

    /**
     * 中序遍历
     */
    fun ldrTree(treeNode: GBTType?) {
        if(treeNode != null) {
            ldrTree(treeNode.left)
            treeNodeData(treeNode)
            ldrTree(treeNode.right)
        }
    }

    /**
     * 后序遍历
     */
    fun rdlTree(treeNode: GBTType?) {
        if(treeNode != null) {
            rdlTree(treeNode.left)
            rdlTree(treeNode.right)
            treeNodeData(treeNode)
        }
    }


    companion object {
        const val MAX_LEN = 20
    }
}