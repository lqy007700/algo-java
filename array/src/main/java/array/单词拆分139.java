package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分139 {
    public static void main(String[] args) {
        单词拆分139 a = new 单词拆分139();
        boolean b = a.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(b);
    }

    /**
     * leetcode ["leet","code"]
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        System.out.println(wordDictSet.contains(s.substring(0, 1)));
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
