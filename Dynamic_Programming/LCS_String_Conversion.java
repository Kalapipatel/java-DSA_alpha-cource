package Dynamic_Programming;

public class LCS_String_Conversion {
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

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
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void stringConversion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int len_lcs = lcs(str1, str2);

        int del = n - len_lcs;
        int ins = m - len_lcs;

        System.out.println("deleted operations = " + del);
        System.out.println("inserted operations = " + ins);
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";

        // String str1 = "pear";
        // String str2 = "sea";
        stringConversion(str1, str2);
    }
}
