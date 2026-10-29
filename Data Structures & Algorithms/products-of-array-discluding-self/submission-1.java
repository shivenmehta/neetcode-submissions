class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];

        int[] second = new int[nums.length];

        Arrays.fill(second, 1);
        Arrays.fill(answers, 1);
        // System.out.println(Arrays.toString(answers));

        for (int i = nums.length - 1; i > 0; i--) {
            answers[i-1] = answers[i] * nums[i];
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            second[i+1] = second[i] * nums[i];
        }

        int[] test = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            test[i] = answers[i] * second[i];
        } 

        // System.out.println(Arrays.toString(second));
        // System.out.println(Arrays.toString(answers));
        // System.out.println(Arrays.toString(test));

        return test;
    }
}  
