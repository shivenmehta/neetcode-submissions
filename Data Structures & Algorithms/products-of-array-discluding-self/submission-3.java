class Solution {
    public int[] productExceptSelf(int[] nums) {

        //Naive Solution
        // int[] answers = new int[nums.length];

        // int[] second = new int[nums.length];

        // Arrays.fill(second, 1);
        // Arrays.fill(answers, 1);
        // // System.out.println(Arrays.toString(answers));

        // for (int i = nums.length - 1; i > 0; i--) {
        //     answers[i-1] = answers[i] * nums[i];
        // }
        
        // for (int i = 0; i < nums.length - 1; i++) {
        //     second[i+1] = second[i] * nums[i];
        // }

        // int[] test = new int[nums.length];

        // for (int i = 0; i < nums.length; i++) {
        //     test[i] = answers[i] * second[i];
        // } 

        // // System.out.println(Arrays.toString(second));
        // // System.out.println(Arrays.toString(answers));
        // // System.out.println(Arrays.toString(test));

        //Optimized Solution

        int[] answers = new int[nums.length];

        Arrays.fill(answers, 1);

        int suffix = 1;
        int prefix = 1;


        for (int i = 0; i < nums.length - 1; i++) {
            int j = nums.length - i - 1;

            suffix *= nums[j];
            prefix *= nums[i];

            answers[j-1] = suffix * answers[j-1];
            answers[i+1] = prefix * answers[i+1];
            
        }

        return answers;
    }
}  
