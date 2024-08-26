package Array_2D;

import java.util.ArrayList;
import java.util.List;

public class set_matrix_0 {
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        while (!row.isEmpty()) {
            int rowidx = row.remove(0);
            int colidx = col.remove(0);

            for (int j = 0; j < m; j++) {
                matrix[rowidx][j] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][colidx] = 0;
            }

        }

        print(matrix);
    }

    public static void optimal(int matrix[][]) {
        // col -> matrix[0][...]
        // row -> matrix[...][0]
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // marked i-th row
                    matrix[i][0] = 0;

                    // mark j-th col
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    // check for row and col
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println("for optimul sol (SC -> O(1))");
        print(matrix);
    }

    public static void main(String agrs[]) {
        int[][] arr = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        // setZeroes(arr);
        optimal(arr);
    }
}
