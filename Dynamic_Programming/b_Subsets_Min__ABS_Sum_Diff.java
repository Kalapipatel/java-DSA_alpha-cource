package Dynamic_Programming;

public class b_Subsets_Min__ABS_Sum_Diff {
    public static void print(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean target_sum(int arr[], int t, int n, boolean dp[][]) {

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]] == true) {
                    dp[i][j] = true;
                }

                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        // print(dp);

        return dp[n][t];
    }

    public static int min_diff(int arr[]) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean dp[][] = new boolean[n + 1][sum + 1];

        target_sum(arr, sum, n, dp);

        int min = Integer.MAX_VALUE;

        for (int j = 0; j <= sum; j++) {
            if (dp[n][j]) {
                int s1 = j;
                int s2 = (sum - s1);

                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;
    }

    public static void main(String args[]) {
        // int arr[] = { 4, 2, 7, 1, 3 };
        int arr[] = { 3, 2, 7 };
        // int target = 10;

        System.out.println(min_diff(arr));
        // (3+2) - (7) = 2 is the ans

    }
}
