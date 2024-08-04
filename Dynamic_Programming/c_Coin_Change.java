package Dynamic_Programming;

public class c_Coin_Change {
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int coin_change(int arr[], int tar) {
        int n = arr.length;
        int dp[][] = new int[n + 1][tar + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= tar; j++) {
                int val = arr[i - 1];
                int nonpick = dp[i - 1][j];
                int pick = 0;
                if (val <= j) {
                    pick = dp[i][j - val];
                }
                dp[i][j] = pick + nonpick;
            }
        }

        print(dp);

        return dp[n][tar];
    }

    public static void main(String args[]) {
        // int arr[] = { 1, 2, 3 };
        // int T = 4; // 4 is the ans
        int arr[] = { 2, 5, 3, 6 };
        int T = 10; // 5 is the ans

        System.out.println(coin_change(arr, T));
    }
}
