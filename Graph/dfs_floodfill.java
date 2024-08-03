package Graph;

public class dfs_floodfill {
    public static void dfs(int[][] ans, int[][] img, int row, int col, int[] delrow, int[] delcol, int newCol,
            int iniCol) {
        ans[row][col] = newCol;
        int n = img.length;
        int m = img[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && img[nrow][ncol] == iniCol
                    && ans[nrow][ncol] != newCol) {
                dfs(ans, img, nrow, ncol, delrow, delcol, newCol, iniCol);
            }
        }
    }

    public static int[][] floodfill(int[][] img, int sr, int sc, int newCol) {
        int iniCol = img[sr][sc];
        int ans[][] = img;

        int delrow[] = { -1, 0, 1, 0 };
        int delcol[] = { 0, 1, 0, -1 };

        dfs(ans, img, sr, sc, delrow, delcol, newCol, iniCol);
        return ans;
    }

    public static void main(String args[]) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        int ans[][] = floodfill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
