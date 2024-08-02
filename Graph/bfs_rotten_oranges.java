package Graph;

import java.util.*;

public class bfs_rotten_oranges {
    static class info {
        int i;
        int j;
        int time;

        public info(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static int rotten(int[][] grid) {
        Queue<info> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int c1 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new info(i, j, 0));
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    c1++;
                }
            }
        }

        System.out.println("count is : " + c1);

        int time = 0;
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int r = q.peek().i;
            int c = q.peek().j;
            int t = q.peek().time;
            time = Math.max(time, t);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2) {
                    q.add(new info(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 2;
                    c1--;
                }
            }
        }

        if (c1 > 0) {
            System.out.println("now count is : " + c1);
            System.out.println("There is some fresh orange left");
            return -1;
        } else {
            System.out.println("now count is : " + c1);
        }

        return time;
    }

    public static void main(String args[]) {
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        int[][] grid2 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        System.out.println(rotten(grid));
        System.out.println();
        System.out.println(rotten(grid2));
    }
}
