package DynamicPrograming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // top-down approach
    public boolean usingRecurtion(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, 0, set, memo);
    }

    public boolean helper(String s, int start, Set<String> wordDict, Boolean[] memo) {
        if (start == s.length()) return true;
        if(memo[start] != null) return memo[start];
        for (int end = start+1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                if (helper(s, end, wordDict, memo)) return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    // bottom-up approach
    public boolean usingRecursionReverse(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length() + 1];
        return helper(s, s.length(), set, memo);
    }

    public boolean helperForReverse(String s, int end, Set<String> wordDict, Boolean[] memo) {
        if (end == 0) return true;

        if (memo[end] != null) return memo[end];

        for (int start = end - 1; start >= 0; start--) {
            String word = s.substring(start, end);

            if (wordDict.contains(word)) {
                if (helperForReverse(s, start, wordDict, memo)) {
                    return memo[end] = true;
                }
            }
        }

        return memo[end] = false;
    }

    // top-down approach

    public boolean usingDpForward(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;

            StringBuilder sb = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));

                if (wordSet.contains(sb.toString())) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[s.length()];
    }

    // bottom-up approach

    public boolean usingDp(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                if (wordSet.contains(sb.toString())) {
                    dp[i] = dp[j + 1];
                    if(dp[j+1]) break;
                }
            }
            sb.setLength(0);
        }

        return dp[0];

    }



    void main() {
        System.out.println(usingDp("leetcode", List.of("leet", "code")));
//        System.out.println(usingDp("applepenapple", List.of("apple", "pen")));
//        System.out.println(usingDp("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(usingDp("aaaaaaa", List.of("aaaa", "aaa")));
    }


}
