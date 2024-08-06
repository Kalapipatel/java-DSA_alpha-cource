package Dynamic_Programming;

// We are given two strings S1 and S2, we want to know how many distinct subsequences of S2 are present in S1.
public class d_Distinct_Subsequences {
    public static int dist_subsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String s1 = "babgbag";
        String s2 = "bag";

        int ans = dist_subsequence(s1, s2);
        System.out.println(ans); // 5
    }
}
