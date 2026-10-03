class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int hayStart = i;
            boolean breakout = false;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(hayStart) == needle.charAt(j)) {
                    hayStart++;
                } else {
                    breakout = true;
                    break;
                }
            }
            if (!breakout) {
                return i;
            }
        }
        return -1;
    }
}