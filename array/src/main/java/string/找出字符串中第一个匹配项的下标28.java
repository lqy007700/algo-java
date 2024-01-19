package string;

public class 找出字符串中第一个匹配项的下标28 {
    public static void main(String[] args) {
        找出字符串中第一个匹配项的下标28 a = new 找出字符串中第一个匹配项的下标28();
        try {
            a.strStr(null, null);

        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0 || m > n) return 0;

        char[] sChar = haystack.toCharArray();
        char[] nChar = needle.toCharArray();

        for (int i = 0; i <= n - m; i++) {

            int j = i, k = 0;
            while (k < m && sChar[j] == nChar[k]) {
                j++;
                k++;
            }
            if (k == m) {
                return i;
            }
        }
        return -1;
    }
}
