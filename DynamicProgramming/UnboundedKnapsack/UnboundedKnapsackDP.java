package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class UnboundedKnapsackDP {
    private static int getMaximumValueHelper(int weights[], int values[], int n, int maxWeight, int knapsack[][]) {
        if(n == 0 || maxWeight == 0) {
            return 0;
        }

        if(knapsack[n][maxWeight] != -1) {
            return knapsack[n][maxWeight];
        }

        if(weights[n - 1] > maxWeight) {
            int result = getMaximumValueHelper(weights, values, n - 1, maxWeight, knapsack);
            knapsack[n][maxWeight] = result;

            return result;
        }

        int include = values[n - 1] + getMaximumValueHelper(weights, values, n, maxWeight - weights[n - 1], knapsack);
        int exclude = getMaximumValueHelper(weights, values, n - 1, maxWeight, knapsack);

        int maximum = Math.max(include, exclude);

        knapsack[n][maxWeight] = maximum;

        return maximum;
    }

    public static int getMaximumValue(int weights[], int values[], int n, int maxWeight){
        int knapsack[][] = new int[n + 1][maxWeight + 1];
        for(int k[] : knapsack) {
            Arrays.fill(k, -1);
        }

        return getMaximumValueHelper(weights, values, n, maxWeight, knapsack);
    }
}
