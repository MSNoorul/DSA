package Arrays;

public class MaxCircularSubArraySum {

    public int usingKadanseAlgo(int arr[]) {
        // code here
        int n = arr.length;


        int curSum = 0;
        int maxSum = arr[0];

        int total = 0;
        int curMin = 0;
        int minSum = arr[0];


        for(int i=0;i<n;i++){

            curMin += arr[i];
            curSum += arr[i];
            total += arr[i];

            minSum = Math.min(curMin ,minSum);
            maxSum = Math.max(curSum , maxSum);

            if(curMin >0) curMin = 0;
            if(curSum <= 0)  curSum = 0;
        }

        System.out.println("final minsum :" + minSum);
        System.out.println("final maxsum :" + maxSum);
        System.out.println("final total :" + total);

        if(total < 0) return maxSum;

        return Math.max(maxSum , (total - minSum));

    }

    public int maxCircularSum(int arr[]) {
        int n = arr.length;

        int total = 0;

        int curMax = 0, maxSum = Integer.MIN_VALUE;
        int curMin = 0, minSum = Integer.MAX_VALUE;

        for (int x : arr) {
            // Normal Kadane for max subarray
            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);

            // Kadane for min subarray
            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);

            total += x;
        }

        System.out.println("final minsum :" + minSum);
        System.out.println("final maxsum :" + maxSum);
        System.out.println("final total :" + total);

        // If all numbers are negative, maxSum is correct (total == minSum)
        if (maxSum < 0) return maxSum;

        // Otherwise, consider circular sum
        return Math.max(maxSum, total - minSum);
    }

    void main(){
        MaxCircularSubArraySum mcsa = new MaxCircularSubArraySum();
        int[] arr = {-14, -41, 49, 28, -4, 27, -17, 43, -35, -42, 40, -21, 48, 4, -7, 36, 33,
                -39, 26, -14, -31, 19, -47, -31, -19, 49, -7, 18, -3, -13, -14, -47,
                -48, 44, -41, -9, -25, 49, -25, -48, -17, 49, -24, 31, 15, 10};
        System.out.println(mcsa.usingKadanseAlgo(arr));
        System.out.println(mcsa.maxCircularSum(arr));
    }

}
