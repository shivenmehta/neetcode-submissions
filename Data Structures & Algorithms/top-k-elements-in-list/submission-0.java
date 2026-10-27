class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyTracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequencyTracker.containsKey(nums[i])) {
                frequencyTracker.put(nums[i], frequencyTracker.get(nums[i]) + 1);
            } else {
                frequencyTracker.put(nums[i], 1);
            }
        }
        System.out.println(frequencyTracker);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        for (int key: frequencyTracker.keySet()) {
            int[] pair = {key, frequencyTracker.get(key)};
            minHeap.add(pair);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // int[] result = new int[k];

        // for (int i = 0; i < k; i++) {
        //     int[] pair = minHeap.poll();
        //     result[i] = pair[0];
        // }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }


        return result;
    }
    
}
