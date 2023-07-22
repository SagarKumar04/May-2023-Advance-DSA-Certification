package DynamicProgramming.InClass.UnboundedKnapsack.InClass;

import java.util.Arrays;

public class CutTheRodDP {
    private static int getMaxProfitHelper(int a[], int n, int profit[]) {
        if(n == 0) {
            return 0;
        }

        if(profit[n] != -1) {
            return profit[n];
        }

        int maxProfit = -1;
        for(int i = 1; i <= n; i++) {
            maxProfit = Math.max(maxProfit, a[i - 1] + getMaxProfitHelper(a, n - i, profit));
        }

        profit[n] = maxProfit;

        return maxProfit;
    }

    public static int getMaxProfit(int[] a, int n) {
        int profit[] = new int[n + 1];
        Arrays.fill(profit, -1);
        return getMaxProfitHelper(a, n, profit);
    }
}
