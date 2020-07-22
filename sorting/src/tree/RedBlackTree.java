package tree;

/**
 * @author hankin
 * @date 2020/7/22 22:29
 */
public class RedBlackTree {
    /**
     * 红黑树性质：
     * 1、每个节点非红即黑
     * 2、不可能有连在一起的红色节点(黑色节点可以)，每个叶子节点都是黑色的空节点（NIL），也就是说叶子节点不存储数据
     * 3、root节点是黑色的
     * 4、每个节点，从该节点到达其可达叶子节点的所有路径，都包含相同数目的黑色节点
     */

    /**
     * 为了满足红黑树的性质所以出现了，红黑树的变换：
     * 1、改变颜色 红->黑 黑->红
     * 2、左旋：
     * 3、右旋：
     *
     *
     * 左旋：      |           |
     *           10           15
     *          / \          / \
     *         5  15       10   20
     *           / \      / \
     *          12 20    5  12
     *
     * 右旋：
     *          |            |
     *         15           10
     *        / \          / \
     *       10 20        5  15
     *      / \             / \
     *     5  12           12 20
     *
     * 所有新加的点都是红色
     */


    /**
     * 变色条件：
     *  当前节点的父亲是红色 叔叔节点也是红色
     *  父节点   -> 黑色
     *  叔叔节点 -> 黑色
     *  爷爷节点 -> 红色
     *  把指针定义到爷爷节点设为当前要操作的
     *
     * 左旋条件：
     *  父节点红色
     *  叔叔节点是黑色
     *  当前节点是右子树
     *  以父节点左旋
     *
     * 右旋条件：
     *  父节点红色
     *  叔叔节点是黑色
     *  当前节点是右子树
     *  父亲->黑色
     *  爷爷->红色
     *  以爷爷点右旋
     *
     *
     */
}