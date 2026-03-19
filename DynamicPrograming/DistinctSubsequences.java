package DynamicPrograming;
import java.util.*;

/**
 * Given two strings s and t, return the number of distinct subsequences ofs which equals t.
 * --------------
 * Constraints:
 * ● 1 <= s.length, t.length <= 1000
 * ● s and t consist of English letters.
 * ---------
 * Example 1:
 * Input:
 * s = "rabbbit"
 * t = "rabbit"
 * Output:
 * 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit"from s.
 * rabbbit
 * rabbbit
 * rabbbit
 * --------------
 * Example 2:
 * Input:
 * s = "babgbag"
 * t = "bag"
 * Output:
 * 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag"from s.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * */

public class DistinctSubsequences {

    public int usingRecursion(String s , String t ){
         int[] cnt = {0};
         dfs(s,t,new StringBuilder(),0,cnt);
         return cnt[0];
    }

    public void dfs(String source ,String target,StringBuilder cur , int index,int[] cnt){

        if(cur.length() > target.length() || index > source.length()) return;

        if(cur.toString().equals(target)){
            cnt[0]++;
            return;
        }

        if(index== source.length()) return;

        cur.append(source.charAt(index));
        dfs(source,target,cur,index+1,cnt);

        cur.deleteCharAt(cur.length()-1);
        dfs(source,target,cur,index+1,cnt);
    }


    void main(){
        String s = "babgbag";
        String t = "bag";
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        System.out.println(sb.toString().equals("a"));
        System.out.println(usingRecursion(s,t));
    }
}
