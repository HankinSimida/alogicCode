package tree.traversal;

/**
 * @author hankin
 * @date 2020/7/21 17:05
 */
public class TreeNodeDefinition {
    private char data;
    private TreeNodeDefinition left;
    private TreeNodeDefinition right;

    @Override
    public String toString() {
        return "TreeNodeDefinition{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNodeDefinition(char data, TreeNodeDefinition left, TreeNodeDefinition right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TreeNodeDefinition getLeft() {
        return left;
    }

    public void setLeft(TreeNodeDefinition left) {
        this.left = left;
    }

    public TreeNodeDefinition getRight() {
        return right;
    }

    public void setRight(TreeNodeDefinition right) {
        this.right = right;
    }


}
