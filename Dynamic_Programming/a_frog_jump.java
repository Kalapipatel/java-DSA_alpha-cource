package Dynamic_Programming;

import java.util.Arrays;

public class a_frog_jump {
    public static int frog_jump(int n, int height[], int dp[]) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int two = Integer.MAX_VALUE;
        int one = frog_jump(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);

        if (n > 1)
            two = frog_jump(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);

        return dp[n] = Math.min(two, one);

    }

    public static int frog_jump_nSteps(int n, int height[], int k) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);

        for (int i = 2; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return dp[n - 1];
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frog_jump(n - 1, height, dp));

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }

        System.out.println("\nwith k steps");
        System.out.println(frog_jump_nSteps(n, height, 5));
        System.out.println();

    }
}
