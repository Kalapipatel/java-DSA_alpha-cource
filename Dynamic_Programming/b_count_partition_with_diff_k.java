package Dynamic_Programming;

import java.util.Arrays;

public class b_count_partition_with_diff_k {
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
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

        // print(dp);
        return dp[n - 1][k];
    }

    public static int countPartitions(int arr[], int d) {
        int sum = Arrays.stream(arr).sum();

        if (sum - d < 0 || (sum - d) % 2 == 1)
            return 0;

        return count_subsets_tab(arr, (sum - d) / 2);
    }

    public static void main(String args[]) {
        int arr[] = { 5, 2, 6, 4 };
        int d = 3;

        System.out.println(countPartitions(arr, d));
    }
}
