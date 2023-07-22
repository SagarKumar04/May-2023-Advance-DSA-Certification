package DynamicProgramming.InClass.UnboundedKnapsack.InClass;

public class CutTheRodRecursion {
    private static int getMaxProfitHelper(int a[], int n) {
        if(n == 0) {
            return 0;
        }

        int maxProfit = -1;
        for(int i = 1; i <= n; i++) {
            maxProfit = Math.max(maxProfit, a[i - 1] + getMaxProfitHelper(a, n - i));
        }

        return maxProfit;
    }

    public static int getMaxProfit(int[] a, int n) {
        return getMaxProfitHelper(a, n);
    }
}
