package algorithm;

import java.util.Arrays;

public class KPaldindrome {
    public static boolean isKPalindrome(String s, int k) {
        int n = s.length();
        String reverseS = new StringBuilder(s).reverse().toString();

        // Initialize a 2D array to store the LCS length
        int[][] dp = new int[n + 1][n + 1];

        // Calculate the LCS using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reverseS.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the LCS
        int lcsLength = dp[n][n];

        // Check if the string is a k-palindrome
        return (n - lcsLength) <= k;
    }
    public static int modifiedEditDistance(String a, String b, int k) {
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];

        // Initialize dp matrix to a value > 1,000,000,000
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1000000000);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int from = Math.max(1, i - k);
            int to = Math.min(i + k, n);
            for (int j = from; j <= to; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) { // same character
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Note that we don't allow letter substitutions
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]); // delete character j
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]); // insert character i
            }
        }

        return dp[n][n];
    }


    public static void main(String[] args) {
        String s = "abcde";
        int k = 1;
        boolean result = isKPalindrome(s, k);
        System.out.println("Is the string a " + k + "-palindrome? " + result);
        String a = "abcdef";
        String b = "abxefg";
        int res= modifiedEditDistance(a, b, k);
        System.out.println("Modified Edit Distance: " + res);
    }
}
/*
 * isKPalindrome method takes a string s and an integer k as input and returns a boolean value indicating whether the string is a k-palindrome.
 * n is the length of the input string s. We create a reversed string reverseS by using StringBuilder to reverse s.
 * dp is a 2D array used to store the length of the Longest Common Subsequence (LCS) between s and reverseS.
 * The dynamic programming loop calculates the LCS between s and reverseS. The dp[i][j] represents the LCS length of the substrings s.substring(0, i) and reverseS.substring(0, j).
 * If the characters at position i - 1 and j - 1 in s and reverseS match, we extend the LCS by 1 (dp[i][j] = dp[i - 1][j - 1] + 1). Otherwise, we take the maximum LCS from the previous row or column (dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])).
 * The length of the LCS (lcsLength) between s and reverseS is stored in dp[n][n].
 * To check if the string is a k-palindrome, we compare the length of the string s minus the length of the LCS (n - lcsLength) with k. If it's less than or equal to k, then the string is a k-palindrome.
 * In the main method, we test the isKPalindrome method with the string "abcde" and k = 1. The result will be printed to the console.
*/
