/**
 * @author hankin
 * @date 2020/7/27 16:56
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * <p>
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 题源 289
 */
public class LifeGame {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        // 行
        int outNum = board.length;
        // 列
        int inNum = board[0].length;

        int[][] die = new int[outNum][inNum];
//        int[][] live = new int[outNum][inNum];

        for (int i = 0; i < outNum; i++) {
            for (int j = 0; j < inNum; j++) {
                if (board[i][j] == 0) {
                    int dieNum = 0;
                    dieNum = judge(board, i, j, dieNum);
                    if (dieNum == 3) {
                        die[i][j] = 1;
                    }
                } else {
                    int liveNum = 0;
                    liveNum = judge(board, i, j, liveNum);
                    if (liveNum == 2 || liveNum == 3) {
                        die[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < outNum; i++) {
            for (int j = 0; j < inNum; j++) {
                board[i][j] = die[i][j];
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int judge(int[][] board, int i, int j, int count) {
        try {
            if (board[i - 1][j - 1] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i - 1][j] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i - 1][j + 1] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i][j - 1] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i][j + 1] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i + 1][j - 1] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i + 1][j] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        try {
            if (board[i + 1][j + 1] == 1) {
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }
}
