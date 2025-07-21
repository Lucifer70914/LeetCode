class Solution {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();

        int index = 1; 
        int count = 1; 

        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                chars[index++] = chars[i];
            }
        }

        return new String(chars, 0, index);
    }
}
