package string;

public class 最长公共前缀14 {
    public static void main(String[] args) {
        最长公共前缀14 a = new 最长公共前缀14();
        String s = a.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }

    // ["flower","flow","flight"]
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }

    private String getCommonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int idx = 0;

        while (idx < len && s1.charAt(idx) == s2.charAt(idx)) {
            idx++;
        }

        return s1.substring(0, idx);
    }
}
