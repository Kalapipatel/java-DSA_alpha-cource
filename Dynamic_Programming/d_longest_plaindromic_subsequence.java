package Dynamic_Programming;

public class d_longest_plaindromic_subsequence {
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static int longest_palindrom(String str) {
        StringBuilder temp = new StringBuilder(str);
        temp.reverse();
        String str2 = temp.toString();

        return lcs(str, str2);
    }

    public static void main(String args[]) {

        System.out.println(longest_palindrom("bbabcbcab")); // 7
    }
}
