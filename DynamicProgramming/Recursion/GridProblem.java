package DynamicProgramming.Recursion;

import java.util.Scanner;

public class GridProblem {
    private static int countPaths(int x, int y) {
        if(x == 0 || y == 0) {
            return 1;
        }

        return countPaths(x, y - 1) + countPaths(x - 1, y);
    }

    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int count = countPaths(n - 1, m - 1);

        System.out.println(count);
    }
}
