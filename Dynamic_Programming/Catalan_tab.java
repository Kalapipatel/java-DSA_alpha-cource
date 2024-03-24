package Dynamic_Programming;

public class Catalan_tab {
    public static int catalan_tab(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4;
        System.out.println(catalan_tab(n));
    }
}
