package Dynamic_Programming;

import java.util.Arrays;

public class b_count_subset_with_sum {
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int count_subsets_rec(int arr[], int n, int k, int dp[][]) {
        // if there is no 0's in arr then this is correct
        // if (k == 0)
        // return 1;

        // if (n == 0) {
        // if (arr[0] == k)
        // return 1;
        // else
        // return 0;
        // }

        // but when 0's come then we have to modify it
        if (n == 0) {
            if (k == 0 && arr[0] == 0)
                return 2; // 2 ways, by including or not there is no effect on sum

            if (k == 0 || k == arr[0])
                return 1; // ( (arr[0]=5, sum=0)->exclude, (arr[0]=5, sum=5) -> include) on;y 1 way in any
                          // possibility

            return 0;
        }

        if (dp[n][k] != -1)
            return dp[n][k];

        int nonpick = count_subsets_rec(arr, n - 1, k, dp);
        int pick = 0;

        if (arr[n] <= k) {
            pick = count_subsets_rec(arr, n - 1, k - arr[n], dp);
        }

        return dp[n][k] = pick + nonpick;
    }

    public static int count_subsets_tab(int arr[], int k) {
        int n = arr.length;
        int dp[][] = new int[n][k + 1];

        if (arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if (arr[0] != 0 && k >= arr[0])
            dp[0][arr[0]] = 1; // arr[0] = 5

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int val = arr[i];
                int pick = 0;
                if (val <= j) {
                    pick = dp[i - 1][j - val];
                }
                int nonpick = dp[i - 1][j];
                dp[i][j] = pick + nonpick;
            }
        }

        print(dp);
        return dp[n - 1][k];
    }

    public static void main(String args[]) {
        // int arr[] = { 1, 2, 2, 3 };
        // int k = 3;
        int arr[] = { 0, 0, 1 };
        int k = 1;
        int n = arr.length;

        System.out.println("tabulation : ");
        System.out.println(count_subsets_tab(arr, k));

        int dp[][] = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("recursion : ");
        System.out.println(count_subsets_rec(arr, n - 1, k, dp));
        print(dp);
    }
}
