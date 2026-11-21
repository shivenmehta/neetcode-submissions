class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map<Integer,Integer> prefixSumMap = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > k) {
        //         prefixSumMap.put(i, 0);
        //         continue;
        //     } else if (i == 0 || prefixSumMap.get(i-1) == 0) {
        //         prefixSumMap.put(i, nums[i]);
        //     } else {
        //         int aggregatedSum = nums[i] + prefixSumMap.get(i-1);
        //         if (aggregatedSum > k) {
        //             prefixSumMap.put(i, nums[i]);
        //         } else {
        //             prefixSumMap.put(i, prefixSumMap.get(i - 1) + nums[i]);
        //         }
        //     }

        // }
        // System.out.println(prefixSumMap);
        // return 0;

        // Map<Integer,Integer> prefixCounts = new HashMap<>();
        // List<Integer> prefixSum = new ArrayList<>();

        // prefixSum.addFirst(0);

        // //Create the PrefixSum Array
        // for (int i = 0; i < nums.length; i++) {
        //     prefixSum.add(nums[i] + prefixSum.get(i));
        // }

        // System.out.println(prefixSum);

        // int answer = 0;

        // for (int i = 0; i < prefixSum.size(); i++) {
        //     int currentPrefix = prefixSum.get(i);
        //     int previousPrefix = currentPrefix - k;

        //     if (prefixCounts.containsKey(previousPrefix)) {
        //         int numSubArrays = prefixCounts.get(previousPrefix);
        //         answer = answer + numSubArrays;
        //     } 

        //     if (prefixCounts.containsKey(currentPrefix)) {
        //         prefixCounts.put(currentPrefix, 1 + prefixCounts.get(currentPrefix));
        //     } else {
        //         prefixCounts.put(currentPrefix, 1);
        //     }
            
        // }







        int[] prefixSum = new int[nums.length + 1];
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        prefixSum[0] = 0;
        int aggregatedSum = 0;

        for (int i = 0; i < nums.length; i++) {
            aggregatedSum += nums[i];
            prefixSum[i+1] = aggregatedSum;
        }

        // for (int i = 0; i < prefixSum.length; i++) {
        //     if (prefixSumMap.containsKey(prefixSum[i])) {
        //         List<Integer> keyList = prefixSumMap.get(prefixSum[i]);
        //         keyList.add(i);
        //         prefixSumMap.put(prefixSum[i], keyList);
        //     } else {
        //         List<Integer> newList = new ArrayList<>();
        //         newList.add(i);
        //         prefixSumMap.put(prefixSum[i], newList);
        //     }
        // }

        // System.out.println(prefixSumMap);

        int answers = 0;

        for (int i = 0; i < prefixSum.length; i++) {
            int currentSum = prefixSum[i];
            int targetSum = currentSum - k;

            // if (prefixSumMap.containsKey(targetSum)) {
            //     answers += prefixSumMap.get(targetSum);
            //     prefixSumMap.put(prefixSum[i], prefixSumMap.get(prefixSum[i]) + 1);
            // } else {
            //     prefixSumMap.put(prefixSum[i], 1);
            // }

            if (prefixSumMap.containsKey(targetSum)) {
                answers += prefixSumMap.get(targetSum);
            } 
            if (prefixSumMap.containsKey(prefixSum[i])) {
                prefixSumMap.put(prefixSum[i], prefixSumMap.get(prefixSum[i]) + 1);
            } else {
                prefixSumMap.put(prefixSum[i], 1);
            }

        }
        

    
        return answers;
    }
}