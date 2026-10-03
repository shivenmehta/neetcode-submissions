class Solution {

    public boolean check(char c1, char c2) {
        if (c1 == '[') {
            if (c2 == ']') return true;
            return false;
        }
        if (c1 == '(') {
            if (c2 == ')') return true;
            return false;
        }
        if (c1 == '{') {
            if (c2 == '}') return true;
            return false;
        }
        return false;
    }


    public boolean isValid(String s) {
        // int leftIndex = 0;
        // int rightIndex = s.length() - 1;
        // if (s.length() % 2 != 0) { //Can't be valid with odd number of parantheses
        //     return false;
        // }

        // while (leftIndex < rightIndex && check(s.charAt(leftIndex), s.charAt(rightIndex))) {
        //     leftIndex++;
        //     rightIndex--;
        // }

        // if (leftIndex > rightIndex) {
        //     return true;
        // } else {
        //     return false;
        // }
        ArrayList<Character> stack = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(' || s.charAt(index) == '[' ||  s.charAt(index) == '{') {
                stack.addFirst(s.charAt(index));
            } else {
                if (stack.size() <= 0) {
                    return false;
                }
                char popped = stack.removeFirst();
                if (popped == '(') {
                    if (s.charAt(index) != ')') {
                        return false;
                    }
                }
                if (popped == '[') {
                    if (s.charAt(index) != ']') {
                        return false;
                    }
                }
                if (popped == '{') {
                    if (s.charAt(index) != '}') {
                        return false;
                    }
                }
            }
            index++;
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}
