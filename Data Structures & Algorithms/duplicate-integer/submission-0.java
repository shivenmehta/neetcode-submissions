
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tracker.containsKey(nums[i])) {
                return true;
            }
            tracker.put(nums[i], 0);
        }
        return false;
    }
}