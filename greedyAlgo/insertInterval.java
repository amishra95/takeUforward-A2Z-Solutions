

class Solution {
    public int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Phase 1: Add intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge overlapping intervals
        // The overlap exists as long as the current interval starts before the new merged interval ends
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});

        // Phase 3: Add the remaining intervals that start after the merged interval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the dynamic list back to the required 2D array format
        return result.toArray(new int[result.size()][]);
    }
}
