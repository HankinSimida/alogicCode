package tree.hfm;

import java.util.*;

/**
 * @author hankin
 * @date 2020/7/24 22:43
 */
public class HfmTree {
    HfmNode root;

    // 叶子节点
    List<HfmNode> leafs;

    // 叶子节点的权重
    Map<Character, Integer> weights;

    public HfmTree(Map<Character, Integer> weights) {
        this.weights = weights;
        leafs = new ArrayList<>();
    }

    public void createTree() {
        // 拿出所有的点 a b c d e f g
        Character[] keys = weights.keySet().toArray(new Character[0]);
        PriorityQueue<HfmNode> priorityQueue = new PriorityQueue<>();
        for (Character c : keys) {
            HfmNode hfmNode = new HfmNode();
            hfmNode.chars = c.toString();
            hfmNode.fre = weights.get(c);
            priorityQueue.add(hfmNode);
            leafs.add(hfmNode);
        }

        int len = priorityQueue.size();
        for (int i = 1; i <= len - 1; i++) {
            // 每次找最小的两个点合并
            HfmNode n1 = priorityQueue.poll();
            HfmNode n2 = priorityQueue.poll();

            HfmNode newNode = new HfmNode();

            // 值复制 可要可不要
            newNode.chars = n1.chars + n2.chars;
            // 权重相加
            newNode.fre = n1.fre + n2.fre;

            newNode.left = n1;
            newNode.right = n2;

            n1.parent = newNode;
            n2.parent = newNode;

            priorityQueue.add(newNode);
        }
        root = priorityQueue.poll();

    }

    public Map<Character, String> code() {
        Map<Character, String> map = new HashMap<>();
        for (HfmNode node : leafs) {
            String code = "";
            // 叶子节点肯定就一个字符
            Character c = node.chars.charAt(0);
            HfmNode current = node;
            do {
                if (current.parent != null && current == current.parent.left) {
                    code = "0" + code;
                } else {
                    code = "1" + code;
                }
                current = current.parent;
            } while (current.parent != null);
            map.put(c,code);
        }
        return map;
    }

    public static void main(String[] args) {
        Map<Character,Integer> weights = new HashMap<>();
        weights.put('a',3);
        weights.put('b',24);
        weights.put('c',6);
        weights.put('d',20);
        weights.put('e',34);
        weights.put('f',4);
        weights.put('g',12);
        HfmTree hfmTree =new HfmTree(weights);
        hfmTree.createTree();
        Map<Character, String> code = hfmTree.code();
        System.out.println(code);
    }

}
