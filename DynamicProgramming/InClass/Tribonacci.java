package DynamicProgramming.InClass;

public class Tribonacci {
    static int getNthTribonacciUsingTabulation(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1 || n == 2) {
            return 1;
        }

        int[] tribonacci = new int[n + 1];
        tribonacci[0] = 0;
        tribonacci[1] = tribonacci[2] = 1;

        for(int i = 3; i <= n; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }

        return tribonacci[n];
    }


    static int getNthTribonacciUsingMemoization(int n, int tribonacci[]) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(n == 2) {
            return 1;
        }

        if(tribonacci[n] != 0 ) {
            return tribonacci[n];
        }

        int nthTribonacci = getNthTribonacciUsingMemoization(n - 1, tribonacci)
                + getNthTribonacciUsingMemoization(n - 2, tribonacci)
                + getNthTribonacciUsingMemoization(n - 3, tribonacci);

        tribonacci[n] = nthTribonacci;

        return nthTribonacci;

    }

    static int tri(int n){
        //return getNthTribonacciUsingTabulation(n);
        int[] tribonacci = new int[n + 1];
        return getNthTribonacciUsingMemoization(n, tribonacci);
    }
}
