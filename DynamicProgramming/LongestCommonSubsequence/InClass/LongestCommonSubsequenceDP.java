package DynamicProgramming.LongestCommonSubsequence.InClass;

import java.util.Arrays;

public class LongestCommonSubsequenceDP {
    private static int longestCommonSubsequenceHelper(char s1Char[], int i, char s2Char[], int j, int lcsLength[][]) {
        if(i == 0 || j == 0) {
            return 0;
        }

        if(lcsLength[i][j] != -1) {
            return lcsLength[i][j];
        }

        int length;
        if(s1Char[i - 1] == s2Char[j - 1]) {
            length = (1 + longestCommonSubsequenceHelper(s1Char, i - 1, s2Char, j - 1, lcsLength));
            lcsLength[i][j] = length;

            return length;
        }

        length = Math.max(
                longestCommonSubsequenceHelper(s1Char, i, s2Char, j - 1, lcsLength),
                longestCommonSubsequenceHelper(s1Char, i - 1, s2Char, j, lcsLength)
        );

        lcsLength[i][j] = length;

        return length;
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        char s1Char[] = s1.toCharArray();
        int s1Length = s1Char.length;

        char s2Char[] = s2.toCharArray();
        int s2Length = s2Char.length;

        int lcsLength[][] = new int[s1Length + 1][s2Length + 1];
        for(int i = 0; i <= s1Length; i++) {
            Arrays.fill(lcsLength[i], -1);
        }

        return longestCommonSubsequenceHelper(s1Char, s1Length, s2Char, s2Length, lcsLength);
    }
}
