package Dynamic_Programming;

public class b_Partition_Equal_Subset {
    public static boolean target_sum(int arr[], int t) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][t + 1];

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

    public static boolean partition(int arr[]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0)
            return false;
        else {
            if (target_sum(arr, (sum / 2))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        // int arr[] = { 4, 2, 7, 1, 3 };
        int arr[] = { 2, 3, 3, 3, 4, 5 };
        // int target = 10;

        System.out.println(partition(arr));
    }
}
