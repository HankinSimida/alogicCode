package graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author hankin
 * @date 2020/7/27 22:32
 * <p>
 * 0 -> 可以通过
 * 1 -> 无法通过
 * 0(start) 0 1 0
 * 0 0 0 0
 * 0 0 1 0
 * 0 1 0(end) 0
 * 0 0 0 1
 * <p>
 * start -> end
 * <p>
 * <p>
 * 数据量小优先考虑BSF(广度优先)
 */
public class BSF {

    public static void main(String[] args) {
        BSF bsf =new BSF();
        bsf.data= new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0},{0,0,1,0}, {0, 1, 0, 0}, {0, 0, 0, 1}};
        bsf.n=bsf.data.length;
        bsf.m = bsf.data[0].length;
        bsf.mark=new boolean[][]{{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
        bsf.bsf(2,2);

    }

    // n行 m列
    int n;
    int m;

    // end的x end的y data邻接矩阵 mark走过的位置
    int dx;
    int dy;
    int data[][];
    boolean mark[][];

    /**
     * (x,y) -> (dx,dy) ？
     *
     * @param x
     * @param y
     */
    public void bsf(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (x == dx && y == dy) {
            System.out.println("true");
            return;
        }
        mark[x][y] = true;

        Queue<Point> queue = new ArrayBlockingQueue<>(n * m);
        Point start = new Point();
        start.x = x;
        start.y = y;
        queue.add(start);
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            // 取出队列第一个点
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = point.x + next[i][0];
                int nextY = point.y + next[i][1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
                    if (nextX == dx && nextY == dy) {
                        System.out.println("true");
                        return;
                    }
                    Point newPoint = new Point();
                    newPoint.x = nextX;
                    newPoint.y = nextY;
                    mark[nextX][nextY] = true;
                    queue.add(newPoint);
                }
            }
        }
        System.out.println("false");
        return;

    }



}

class Point {
    int x;
    int y;
}
