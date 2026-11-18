class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Brute-Force Solution
        // List<Integer> lsTracker = new ArrayList<>();

        // for (int i = 0; i < s.length(); i++) {
        //     int pointer = i;
        //     int counter = 0;
        //     Set<Character> letterTracker = new HashSet<>();
        //     // letterTracker.add(s.charAt(i));
        //     while (pointer < s.length() && !letterTracker.contains(s.charAt(pointer))) {
        //         letterTracker.add(s.charAt(pointer));
        //         counter = counter + 1;
        //         pointer = pointer + 1;
        //     }
        //     lsTracker.add(counter);
        // }


        // if (lsTracker.size() == 0) {
        //     return 0;
        // }

        //Optimized Solution

        // List<Integer> lsTracker = new ArrayList<>();
        // Set<Character> seen = new HashSet<>();

        // int left = 0;
        // int maxLength = 0;

        // for (int right = 0; right < s.length(); right++) {
        //     while (seen.contains(s.charAt(right))) {
        //         seen.remove(s.charAt(left));
        //         left = left + 1;
        //     } 

        //     seen.add(s.charAt(right));
            
        //     maxLength = Math.max(maxLength, right-left + 1);
            
        // }

        // return maxLength;

















        // Rerun

        Set<Character> charTracker = new HashSet<>();
        
        int maxLength = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!charTracker.contains(s.charAt(i))) {
            
            } else {
                while(s.charAt(left) != s.charAt(i)) {
                    charTracker.remove(s.charAt(left));
                    left = left + 1;
                } 

                charTracker.remove(s.charAt(i));
                left = left + 1;
                
            }

            charTracker.add(s.charAt(i));

            if (charTracker.size() > maxLength) {
                maxLength = charTracker.size();
            }

            // System.out.println(charTracker);
        }

        // for (int i = 0; i < s.length(); i++) {
        //     if (!charTracker.contains(s.charAt(i))) {
        //         charTracker.add(s.charAt(i));

        //     } else {

        //         charTracker.remove(s.charAt(i));

        //     }

        //     if (charTracker.size() > maxLength) {
        //             maxLength = charTracker.size();
        //         }


        //     System.out.println(charTracker);
        // }

        return maxLength;






    }


}
