class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalsList = new ArrayList<>();

        if (intervals.length == 0) {
            int[][] singular = new int[1][2];
            singular[0] = newInterval;
            return singular;
        }

        //Add all the intervals to an ArrayList
        for (int i = 0; i < intervals.length; i++) {
            intervalsList.add(intervals[i]);
        }

        boolean inserted = false;
        //Insert the interval
        for (int i = 0; i < intervalsList.size(); i++) {

            int[] currentInterval = intervalsList.get(i);

            if (newInterval[0] <= currentInterval[0]) {
                intervalsList.add(i, newInterval);
                inserted = true;
                break;
            }
        }

        if (!inserted) intervalsList.add(newInterval);

        ArrayList<int[]> merged = new ArrayList<>();
        
        //Merge Intervals
        for (int i = 0; i < intervalsList.size(); i++) {
            if (merged.size() == 0) { 
                merged.add(intervalsList.get(i));
                continue;
            }

            int[] interval = intervalsList.get(i);
            int[] lastMergedInterval = merged.getLast();

            if (interval[0] <= lastMergedInterval[1]) {
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            } else {
                merged.add(interval);
            }
        }


        // for (int[] arr : merged) {
        //     System.out.println(Arrays.toString(arr));
        // }

        int[][] intervalsArray = merged.toArray(new int[merged.size()][]);
        return intervalsArray;



        // ArrayList<int[]> merged = new ArrayList<>();
        // boolean intervalAdded = false;
        // if (newInterval[0] < intervals[0][0]) {
        //     merged.add(newInterval);
        //     intervalAdded = true;
        // }
        
        // for (int i = 0; i < intervals.length; i++) {
        //     if (merged.size() == 0) {
        //         merged.add(intervals[i]);
        //         continue;
        //     }

        //     int[] lastMergedInterval = merged.getLast();
        //     int[] currentInterval = intervals[i];

        //     if (!intervalAdded) {
        //         if (newInterval[0] <= lastMergedInterval[1]) {
        //             merged.getLast()[1] = Math.max(newInterval[1], lastMergedInterval[1]);
        //         } else {
        //             merged.add(currentInterval);
        //         }
        //     } else {

        //         lastMergedInterval = merged.getLast();

        //         if (currentInterval[0] <= lastMergedInterval[1]) {
        //             merged.getLast()[1] = Math.max(currentInterval[1], lastMergedInterval[1]);
        //         } else {
        //             merged.add(currentInterval);
        //         }
        //     }
        // }

        // for (int[] arr : merged) {
        //     System.out.println(Arrays.toString(arr));
        // }




        // return null;
    }
}
