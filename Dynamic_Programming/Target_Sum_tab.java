package Dynamic_Programming;

public class Target_Sum_tab {
    public static void print(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int val = arr[i - 1];

                // include
                if (val <= j && dp[i - 1][j - val]) {
                    dp[i][j] = true;
                }

                // exclude
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        print(dp);

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int target = 10;

        targetSum(arr, target);
    }
}
