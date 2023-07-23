package DynamicProgramming.LongestCommonSubsequence.InClass;

public class LongestCommonSubsequenceRecursion {
    private static int longestCommonSubsequenceHelper(char s1Char[], int i, char s2Char[], int j) {
        if(i == 0 || j == 0) {
            return 0;
        }

        if(s1Char[i - 1] == s2Char[j - 1]) {
            return (1 + longestCommonSubsequenceHelper(s1Char, i - 1, s2Char, j - 1));
        }

        return Math.max(
                longestCommonSubsequenceHelper(s1Char, i, s2Char, j - 1),
                longestCommonSubsequenceHelper(s1Char, i - 1, s2Char, j)
        );
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        char s1Char[] = s1.toCharArray();
        int s1Length = s1Char.length;

        char s2Char[] = s2.toCharArray();
        int s2Length = s2Char.length;

        return longestCommonSubsequenceHelper(s1Char, s1Length, s2Char, s2Length);
    }
}
