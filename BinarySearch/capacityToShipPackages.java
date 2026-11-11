class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = maxNumber(weights);
        int high = 0;

        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (days(weights, mid) <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int days(int[] weights, int capacity) {
        int daysUsed = 1;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                daysUsed++;
                load = 0;
            }
            load += weights[i];   
        }
        return daysUsed;
    }

    public int maxNumber(int[] weights) {
        int max = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > max) {
                max = weights[i];
            }
        }
        return max;
    }
}
