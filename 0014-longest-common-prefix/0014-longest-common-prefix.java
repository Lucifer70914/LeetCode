class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if (strs == null || len == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            for (int j = 1; j < len; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
