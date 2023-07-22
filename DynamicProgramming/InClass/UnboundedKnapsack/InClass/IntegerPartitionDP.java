package DynamicProgramming.InClass.UnboundedKnapsack.InClass;

public class IntegerPartitionDP {
    private static long partitionIntegerHelper(int n, long partitionProduct[]) {
        if(n == 1) {
            return 1;
        }

        if(partitionProduct[n] != 0) {
            return partitionProduct[n];
        }

        long maxProduct = 1;
        for(int i = 1; i < n; i++) {
            int firstPart = i;
            int secondPart = n - firstPart;

            long partitionResult = partitionIntegerHelper(secondPart, partitionProduct);
            long secondPartMaxProduct = Math.max(secondPart, partitionResult);

            long currentProduct = firstPart * secondPartMaxProduct;

            maxProduct = Math.max(maxProduct, currentProduct);
        }

        partitionProduct[n] = maxProduct;

        return maxProduct;
    }

    public static long partitionInteger(int n) {
        long partitionProduct[] = new long[n + 1];

        return partitionIntegerHelper(n, partitionProduct);
    }
}
