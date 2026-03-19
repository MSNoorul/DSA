package DynamicPrograming;

import java.util.Arrays;

public class LIS {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];

            for(int i=n-1;i>=0;i--){
                int curNum = nums[i];
                int ans = 0;
                for(int j=i;j<n;j++){
                    if(curNum < nums[j]){
                        ans = Math.max(ans, dp[j]) ;
                    }
                }
                dp[i] = ans+1;

            }

            return Arrays.stream(dp).max().orElse(0);
        }
        void main(){
            System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        }

}
