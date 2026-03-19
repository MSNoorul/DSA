package DynamicPrograming;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        for(int a=1;a<= amount;a++){
            int cnt  = Integer.MAX_VALUE;
            for(int coin : coins){
                int idx = a - coin;
                int val = Integer.MAX_VALUE;
                if(idx >=0){
                    val = dp[idx];
                }
                if(val != Integer.MAX_VALUE) cnt = Math.min(val+1,cnt);

            }
            dp[a] = cnt;
        }


        return dp[amount] == Integer.MAX_VALUE ? -1 :dp[amount];
    }

    public int dfs2(int[] coins,int index , int amount,int[][] memo){
        if(amount == 0) return 0;
        if(amount < 0 ) return Integer.MAX_VALUE;
        if(index == coins.length) return Integer.MAX_VALUE;
        if(memo[index][amount] != -1) return memo[index][amount];
        int cnt = Integer.MAX_VALUE;

        for(int i=index;i< coins.length;i++){
            int val = dfs2(coins ,i , amount - coins[i],memo);
            if(val != Integer.MAX_VALUE) cnt = Math.min(val+1,cnt);
        }
        memo[index][amount] = cnt;
        return cnt;
    }

    public int dfs(int[] coins,int index , int amount,int[][] memo){
        if(amount == 0) return 0;
        if(amount < 0 ) return Integer.MAX_VALUE;
        if(index >= coins.length) return Integer.MAX_VALUE;
        if(memo[index][amount] != -1) return memo[index][amount];

        int pick = dfs(coins , index , amount - coins[index],memo);
        if(pick != Integer.MAX_VALUE) pick++;
        int notPick = dfs(coins , index+1 ,amount ,memo);

        int total = Math.min(pick,notPick);

        return memo[index][amount] = total;

    }

    void main(){
        System.out.println(coinChange(new int[]{1,2,3},3));
    }
}
