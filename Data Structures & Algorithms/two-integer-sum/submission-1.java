class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             int[] array = {j, i};
        //             return array;
        //         }  
        //     }        
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             int[] array = {i, j};
        //             return array;
        //         }
        //     }  
        // }
        Map<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (tracker.containsKey(diff)) {
                return new int[] {tracker.get(diff), i};
            } else {
                tracker.put(nums[i], i);
            }
        }
        return null;
    }
}
