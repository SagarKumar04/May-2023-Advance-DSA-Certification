package DynamicProgramming.ZeroOneKnapsack.InClass;

public class ZeroOneKnapsackRecursion {
    static int maxWeightHelper(int w[], int v[], int W, int n) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(w[n - 1] <= W) {
            int includeNthItem = v[n - 1] + maxWeightHelper(w, v, W - w[n - 1], n - 1);
            int excludeNthItem = maxWeightHelper(w, v, W, n - 1);

            int maxValue = Math.max(includeNthItem, excludeNthItem);

            return maxValue;
        }
        else {
            int excludeNthItem = maxWeightHelper(w, v, W, n - 1);
            return excludeNthItem;
        }
    }

    static int maxWeight(int w[], int v[], int W) {
        int n = w.length;

        return maxWeightHelper(w, v, W, n);
    }
}
