package string;

public class 最长回文子串5 {

    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        // 初始化 长度为1的都是回文字符串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        int maxLen = 1;
        int begin = 0;

//        babad

        // 字符串长度
        for (int i = 2; i <= n; i++) {
            // 左
            for (int l = 0; l < n; l++) {
                // 字符串长度 =  右 - 左 + 1
                // 右 = 字符串长度 + 左 - 1
                int r = i + l - 1;
                if (r >= n) {
                    break;
                }

                if (charArray[l] != charArray[r]) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        // 奇数
                        dp[l][r] = true;
                    } else {
                        // 偶数
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }

                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindromeA(String s) {
        int n = s.length();

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int l1 = check(s, i, i);
            int l2 = check(s, i, i + 1);
            int len = Math.max(l1, l2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int check(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l + 1;
    }
}
