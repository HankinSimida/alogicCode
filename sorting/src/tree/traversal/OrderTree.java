package tree.traversal;

import java.util.ArrayDeque;

/**
 * 时间复杂度 O(2*n) -> O(n)
 * 前序遍历 preOrder-order Traversal (VLR)
 * 中序遍历 inorder Traversal (LDR)
 * 中序遍历 post-order Traversal (LRD)
 * A
 * /  \
 * B    E
 * \   \
 * C    F
 * /    /
 * D    G
 * / \
 * H   K
 *
 * @author hankin
 * @date 2020/7/21 16:58
 */
public class OrderTree {
    public static void main(String[] args) {
        TreeNodeDefinition a = getData();

//        preOrder(a);
//        inOrder(a);
//        postOrder(a);
//        BFSOrder(a);
//        printObj(preOrderSearch(a, 'Z'));
//        printObj(inOrderSearch(a, 'D'));
        printObj(postOrderSearch(a, 'F'));

    }


    /**
     * 前序遍历（root left right）
     *
     * @param node
     */
    private static void preOrder(TreeNodeDefinition node) {
        if (node != null) {
            print(node);
        }
        if (node != null && node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if (node != null && node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    /**
     * 中序遍历（left root right）
     *
     * @param node
     */
    private static void inOrder(TreeNodeDefinition node) {
        if (node != null && node.getLeft() != null) {
            inOrder(node.getLeft());
        }
        print(node);
        if (node != null && node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

    /**
     * 后序遍历（left right root）
     *
     * @param node
     */
    private static void postOrder(TreeNodeDefinition node) {
        if (node != null && node.getLeft() != null) {
            postOrder(node.getLeft());
        }
        if (node != null && node.getRight() != null) {
            postOrder(node.getRight());
        }
        print(node);

    }


    /**
     * BFS广度优先搜索（层次遍历）
     *
     * @param node
     */
    private static void BFSOrder(TreeNodeDefinition node) {
        if (node == null) {
            return;
        }
        ArrayDeque<TreeNodeDefinition> queue = new ArrayDeque();
        queue.add(node);
        while (!queue.isEmpty()) {

            // 一定要放判定之前，否则会出大事
            node = queue.poll();
            print(node);
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

        }
    }


    /**
     * 前序查找
     * @param node
     * @param no
     * @return
     */
    private static TreeNodeDefinition preOrderSearch(TreeNodeDefinition node,char no){
        if (node.getData()==no){
            return node;
        }
        TreeNodeDefinition tmp = null;
        if (node.getLeft()!=null){
            tmp=preOrderSearch(node.getLeft(),no);
        }
        if (tmp!=null){
            return tmp;
        }
        if (node.getRight()!=null){
            tmp=preOrderSearch(node.getRight(),no);
        }
        return tmp;

    }

    /**
     * 中序查找
     * @param node
     * @param no
     * @return
     */
    private static TreeNodeDefinition inOrderSearch(TreeNodeDefinition node,char no){
        TreeNodeDefinition tmp = null;
        if (node.getLeft()!=null){
            tmp = inOrderSearch(node.getLeft(),no);
        }
        if (tmp!=null){
            return tmp;
        }
        if (node.getData()==no){
            return node;
        }
        if (node.getRight()!=null){
            tmp=inOrderSearch(node.getRight(),no);
        }
        return tmp;
    }

    /**
     * 后续查找
     * @param node
     * @param no
     * @return
     */
    private static TreeNodeDefinition postOrderSearch(TreeNodeDefinition node,char no){
        TreeNodeDefinition tmp = null;
        if (node.getLeft()!=null){
            tmp = postOrderSearch(node.getLeft(),no);
        }
        if (tmp!=null){
            return tmp;
        }
        if (node.getRight()!=null){
            tmp=postOrderSearch(node.getRight(),no);
        }
        if (tmp!=null){
            return tmp;
        }
        if (node.getData()==no){
            return node;
        }
        return null;
    }

    private static void print(TreeNodeDefinition node) {
        System.out.println(node.getData());
    }
    private static void printObj(TreeNodeDefinition node) {
        System.out.println(node);
    }

    private static TreeNodeDefinition getData() {
        TreeNodeDefinition d = new TreeNodeDefinition('D', null, null);
        TreeNodeDefinition c = new TreeNodeDefinition('C', d, null);
        TreeNodeDefinition b = new TreeNodeDefinition('B', null, c);
        TreeNodeDefinition h = new TreeNodeDefinition('H', null, null);
        TreeNodeDefinition k = new TreeNodeDefinition('K', null, null);
        TreeNodeDefinition g = new TreeNodeDefinition('G', h, k);
        TreeNodeDefinition f = new TreeNodeDefinition('F', g, null);
        TreeNodeDefinition e = new TreeNodeDefinition('E', null, f);
        return new TreeNodeDefinition('A', b, e);
    }

}
