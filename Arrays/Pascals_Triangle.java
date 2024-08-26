package Arrays;

import java.util.ArrayList;

public class Pascals_Triangle {
    public static int nCr(int n, int r) {
        if (r == 1)
            return n;

        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static ArrayList<Integer> printRow(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        long ans = 1;
        row.add(1);

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;

            row.add((int) ans);
        }

        return row;
    }

    public static ArrayList<ArrayList<Integer>> printTriangle(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(printRow(i));
        }

        return ans;
    }

    public static void main(String args[]) {
        int r = 5;
        int c = 3;

        // variation 1 -> Given row number r and column number c. Print the element at
        // position (r, c) in Pascal’s triangle.
        System.out.println(nCr(r - 1, c - 1));

        // variation 2 -> Given the row number n. Print the n-th row of Pascal’s
        // triangle.
        int n = 5;
        System.out.println(printRow(n));

        // variation 3 -> Given the number of rows n. Print the first n rows of Pascal’s
        // triangle.
        System.out.println("\nthe Triangle is:");
        System.out.println(printTriangle(n));
    }
}
