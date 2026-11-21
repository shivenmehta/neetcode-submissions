class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int firstLast = nums[0] + nums[nums.length-1];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        if (dp[0] > nums[1]) {
            dp[1] = dp[0];
        } else {
            dp[1] = nums[1];
        }
        

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        System.out.println(Arrays.toString(dp));

        if (firstLast > dp[dp.length - 1]) {
            return firstLast;
        }
 
        return dp[dp.length - 1]; 
    }
}
