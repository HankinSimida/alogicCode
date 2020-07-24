package tree.hfm;

/**
 * @author hankin
 * @date 2020/7/24 22:46
 */
public class HfmNode implements Comparable<HfmNode> {

    // Node中的字符
    String chars;

    // 频率
    int fre;

    HfmNode left;
    HfmNode right;
    HfmNode parent;

    @Override
    public int compareTo(HfmNode o) {
        return this.fre - o.fre;
    }
}
