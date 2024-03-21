package Dynamic_Programming;

public class LCSubstring {
    public static int lcSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0;

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (n == 0 || m == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGEC";

        System.out.println(lcSubstring(str1, str2));
    }
}
