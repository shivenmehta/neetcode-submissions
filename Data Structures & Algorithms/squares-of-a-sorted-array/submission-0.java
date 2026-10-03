class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        System.out.println(Arrays.toString(nums));

        //Insertion Sort
        for (int j = 1; j < nums.length; j++) {
            int slide = j;
            for (int z = j-1; z >= 0; z--) {
                if (nums[z] > nums[slide]) {
                    int temp = nums[z];
                    nums[z] = nums[slide];
                    nums[slide] = temp;
                    slide--;
                } else {
                    break;
                }
                
            }
        }
        
        return nums;
    }
    
}