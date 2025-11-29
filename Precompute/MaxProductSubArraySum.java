package Precompute;

public class MaxProductSubArraySum {

    public int usingPrefixSuffix(int[] arr) {
            // code here
            int n = arr.length;
            int maxProd = arr[0];

            int[] prefixSum = new int[n];
            int[] suffixSum = new int[n];

            prefixSum[0] = arr[0];
            suffixSum[n-1] = arr[n-1];
            for(int i=1;i<n;i++){
                if(arr[i]==0){
                    prefixSum[i] = 1;
                }
                else prefixSum[i] = prefixSum[i-1] * arr[i];
                if(arr[n-1-i] == 0) suffixSum[n-1-i] = 1;
                else
                    suffixSum[n-1-i] = suffixSum[n-i] * arr[n-1-i];
            }

            maxProd = Math.max(maxProd , prefixSum[n-1]);
            for(int i=0;i<n;i++){
                if(arr[i] <=0 && i==0){
                    maxProd = Math.max(maxProd,suffixSum[i+1]);
                }
                else if(arr[i]<=0 && i==n-1){
                    maxProd = Math.max(maxProd ,prefixSum[i-1]);
                }
                else if(arr[i] <= 0){
                    maxProd = Math.max(prefixSum[i-1] , suffixSum[i+1]);
                }
            }

            return maxProd;
        }
    void main(){
        MaxProductSubArraySum mpsa = new MaxProductSubArraySum();
        int[] arr = {-2 , 6 ,-3 , -10 ,0 ,2};
        System.out.println(mpsa.usingPrefixSuffix(arr));
    }
}


