package tree;

/**
 * @author hankin
 * @date 2020/7/22 17:18
 */
public class OperateBinarySearchTree {
    int data;
    OperateBinarySearchTree left;
    OperateBinarySearchTree right;

    public OperateBinarySearchTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


    /**
     * 增
     * 性能：插入单个logn 插入n个nlogn
     *
     * @param root
     * @param data
     */
    public void insert(OperateBinarySearchTree root, int data) {
        if (root.data < data) {
            if (root.right == null) {
                root.right = new OperateBinarySearchTree(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new OperateBinarySearchTree(data);
            } else {
                insert(root.left, data);
            }
        }

    }


    /**
     * 查找
     * 性能 logn
     * @param root
     * @param data
     */
    public void find(OperateBinarySearchTree root, int data) {
        if (root != null) {
            if (root.data < data) {
                find(root.right, data);
            } else if (root.data > data) {
                find(root.left, data);
            } else {
                System.out.println("find it");
                System.out.println(root.data);
                return;
            }
        }
    }

    /**
     * 删除
     * 情况1：左右子节点都为空（叶子）
     * 情况2：左右子节点有1个为空
     * 情况3：左右子节点都为空 找后继节点而且后继节点的左子树一定为空
     * 性能：情况1 O(1)
     *      情况2 O(1)
     *      情况3 O(logn)
     * @param root
     * @param data
     */
    public void delete(OperateBinarySearchTree root, int data) {
    }

}
