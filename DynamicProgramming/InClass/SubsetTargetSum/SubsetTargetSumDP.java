package DynamicProgramming.InClass.SubsetTargetSum;

public class SubsetTargetSumDP {
    private static int targetSumHelper(int arr[], int target, int n, int subsetSum[][]) {
        if(target == 0) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }

        if(subsetSum[target][n] != -1) {
            return subsetSum[target][n];
        }

        if(arr[n - 1] > target) {
            int result = targetSumHelper(arr, target, n - 1, subsetSum);
            subsetSum[target][n] = result;

            return result;
        }

        int include = targetSumHelper(arr, target - arr[n - 1], n - 1, subsetSum);
        int exclude = targetSumHelper(arr, target, n - 1, subsetSum);

        int result;
        if(include == 1 || exclude == 1) {
            result = 1;
        }
        else {
            result = 0;
        }

        subsetSum[target][n] = result;

        return result;
    }

    public static boolean targetSum(int[] arr, int sum) {
        int n = arr.length;

        int subsetSum[][] = new int[sum + 1][n + 1];
        for(int eachSubsetSum[] : subsetSum) {
            Arrays.fill(eachSubsetSum, -1);
        }

        int result = targetSumHelper(arr, sum, n, subsetSum);

        return ((result == 1) ? true : false);
    }
}
