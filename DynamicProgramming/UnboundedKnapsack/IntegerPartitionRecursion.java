package DynamicProgramming.UnboundedKnapsack;

public class IntegerPartitionRecursion {
    private static long partitionIntegerHelper(int n) {
        if(n == 1) {
            return 1;
        }

        long maxProduct = 1;
        for(int i = 1; i < n; i++) {
            int firstPart = i;
            int secondPart = n - firstPart;

            long secondPartMaxProduct = Math.max(secondPart, partitionIntegerHelper(secondPart));

            long currentProduct = firstPart * secondPartMaxProduct;

            maxProduct = Math.max(maxProduct, currentProduct);
        }

        return maxProduct;
    }

    public static long partitionInteger(int n) {
        return partitionIntegerHelper(n);
    }
}
