class Solution {
    public boolean isPalindrome(String s) {
        

        String cleaned = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                cleaned = cleaned + s.charAt(i);
            }
        }

        int leftIndex = 0;
        int rightIndex = cleaned.length() - 1;
    
        while (leftIndex < rightIndex && cleaned.toLowerCase().charAt(leftIndex) == cleaned.toLowerCase().charAt(rightIndex)) {
            leftIndex++;
            rightIndex--;
        }
        if (leftIndex < rightIndex) {
            return false;
        } else {
            return true;
        }
    }
}
