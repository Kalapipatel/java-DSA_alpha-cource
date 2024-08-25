package Sliding_Window_and_Two_pointer;

public class Longest_Substring_without_Repeating_Character {
    public static int substring(String s) {
        int count = 0;
        int ans = 0;
        boolean vis[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c + " ");

            if (vis[c - 'a'] == false) {
                vis[c - 'a'] = true;
                count++;
                ans = Math.max(ans, count);
                System.out.println(i);
            } else {
                count = 0;
                System.out.println(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";

        System.out.println(substring(s));
        System.out.println(substring(s2));
    }
}
