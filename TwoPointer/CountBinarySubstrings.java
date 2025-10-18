package TwoPointer;
import  java.util.*;
public class CountBinarySubstrings {

    //how i think first
    // 0011 so if i take 0 as -1 when the cunt is 0 then we can find the equal number of zeros and ones are there

    //steps
    // to avoid the grouping issues 00011011 only one time increase and decrese allowed |
    // cnt = -1 -2 -3 -2 -1 -2 break -2 got three time that ming \/\ decrease and increase and decrese aging
    // for the valid aswer only on increase and decrese happens
    // use map to cont the freq if the same number occurs in 3 time that not grouped

    //optimisation
    // to make the O(n2) prev solution to O(n) avoid recomputation 0011 [0[01]1] if we fint the 0011 also add and += len/2 because 01 will inside that 000111 and += len/2 because 0011 and 01 inside that
    // if we find the correct solutin move the i to len 00[11]0011 i =0 to i=2 becase the next 11 will be contribute next
    // if wrong i = j-3 there were the aswer will be

    public int usingTwoPointerAndHashMap(String s) {

        int ans = 0;

        for(int i=0;i<s.length();i++){
            int cnt = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                cnt += s.charAt(j) == '0' ? -1 : 1;
                map.put(cnt , map.getOrDefault(cnt,0)+1);
                if(map.get(cnt)==3) break;
                if(cnt == 0){
                    ans++;
                    break;
                }
            }
        }
        return ans;

    }

    public int usingTwoPointerAnd(String s ){
        int ans = 0;
        char prevEl = s.charAt(0);
        int cntf = 1;
        int cntl = 0;

        for(int i=1;i<s.length();i++){
            if(prevEl == s.charAt(i)) cntf++;
            else {
                char newPrevEl = s.charAt(i);
                int j = i;
                while(j < s.length() && newPrevEl == s.charAt(j)){
                    cntl++;j++;
                }
                ans += Math.min(cntf,cntl);
                cntf = 1;
                prevEl = s.charAt(i);
            }
        }


        return ans;
    }

    public int usingPreProcessing(String s){
        int ans = 0;
        int cnt = 1;
        char prev = s.charAt(0);
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=s.length();i++){
            if(i == s.length()) {
                nums.add(cnt);
                break;
            }
            if(prev == s.charAt(i)) cnt++;
            else {
                nums.add(cnt);
                cnt = 1;
                prev = s.charAt(i);
            }
        }

        for(int i=0;i<nums.size()-1;i++){
            ans += Math.min(nums.get(i) ,nums.get(i+1));
        }
        return  ans;
    }

    void main(){
        var cbs = new CountBinarySubstrings();
        var nums = "00110";
        System.out.println(cbs.usingTwoPointerAnd(nums));
    }
}
