class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {

        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int diff = target - numbers[i];
            while(numbers[j] > diff) {
                j = j-1;
            }
            if (numbers[j] == diff) {
                return new int[]{i + 1, j + 1};
            }
            i = i + 1;
        }
        return null;
    }
}
