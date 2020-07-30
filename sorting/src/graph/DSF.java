package graph;

/**
 *
 * 时间复杂度与路径挂钩-->O(n^2)
 * 优化思路：剪枝
 * 启发式搜索
 * @author hankin
 * @date 2020/7/30 23:21
 */
public class DSF {
    // n行 m列
    int n;
    int m;

    // end的x end的y data邻接矩阵 mark走过的位置
    int dx;
    int dy;
    int data[][];

    // 要走的最小步数
    int minStep = Integer.MAX_VALUE;

    boolean mark[][];
    int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void dfs(int x, int y, int step) {
        if (x == dx && y == dy) {
            if (step < minStep) {
                minStep = step;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                continue;
            }
            if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
                mark[nextX][nextY] = true;
                dfs(nextX, nextY, step + 1);
                System.out.println("x:" + x + " y:" + y);
                // 回溯
                mark[nextX][nextY] = false;
            }
        }
    }

    public DSF(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = mark;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 1}};
        boolean[][] mark = new boolean[][]{{false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}};
        int dx = 3;
        int dy = 2;
        int n = 5;
        int m = 4;
        DSF dsf = new DSF(n, m, dx, dy, data, mark);
        dsf.dfs(0, 0, 0);
        System.out.println(dsf.minStep);
    }
}
