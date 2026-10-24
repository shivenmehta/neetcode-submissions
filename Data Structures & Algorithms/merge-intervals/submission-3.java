class Solution {
    public int[][] merge(int[][] intervals) {
        //Run selection sort on intervals
        for (int i = 0; i < intervals.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < intervals.length; j++) {
                if (intervals[j][0] < intervals[minIndex][0]) {
                    minIndex = j;
                }
            }
            int[] temporary = intervals[i];
            intervals[i] = intervals[minIndex];
            intervals[minIndex] = temporary;
        }



        System.out.println(Arrays.deepToString(intervals));

        List<int[]> merged = new ArrayList<>();

        for (int i = 0 ; i < intervals.length; i++) {
            if (merged.size() == 0) {
                merged.add(intervals[i]);
            }
            int[] last = merged.get(merged.size() - 1);

            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);

        //HashMap was not required :(((())))


        // Map<Integer,Integer> tracker = new HashMap<>();

        // for (int i = 0; i < intervals.length; i++) {
        //     if (!tracker.containsKey(intervals[i][0])) {
        //         tracker.put(intervals[i][0], intervals[i][1]);
        //     }
        //     else {
        //         //Replace the old duration with the new duration if the new duration is longer
        //         if (intervals[i][1] > tracker.get(intervals[i][0])) {
        //             tracker.put(intervals[i][0], intervals[i][1]);
        //         }
        //     }
        // }

        // System.out.println(tracker);

        // int[][] result = new int[tracker.size()][];

        // int counter = 0;
        // for (int key: tracker.keySet()) {
        //     result[counter] = new int[]{key, tracker.get(key)};
        //     counter++;
        // }

        // System.out.println(Arrays.deepToString(result));

        // for (int i = 0; i < result.length; i++) {
        //     int currEnd = result[i][1];
        //     while (currEnd)
        // }


        
	    // for (int key : tracker.keySet()) {
        //     Integer currEnd = tracker.get(key);
        //     while (currEnd != null  && (tracker.containsKey(currEnd) || )) {
        //         tracker.put(key, tracker.get(currEnd));
        //         int removeKey = currEnd;
        //         currEnd = tracker.get(currEnd);
        //         tracker.put(removeKey, null);
        //     }
        // }

        // System.out.println(tracker);

        
        // for (int key: tracker.keySet()) {
        //     if (tracker.get(key) == null) tracker.remove(key);
        // }

        // System.out.println(tracker);

        // int[][] result = new int[tracker.size()][];

        // int counter = 0;
        // for (int key: tracker.keySet()) {
        //     result[counter] = new int[]{key, tracker.get(key)};
        //     counter++;
        // }

        // System.out.println(Arrays.deepToString(result));


    }
}
