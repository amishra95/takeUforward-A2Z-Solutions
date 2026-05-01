class Solution {
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        if (n < m) return -1; 

        int sum = 0;
        int start = 0; 
        int ans = -1;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            start = Math.max(start, nums[i]); 
        }

        int end = sum; 

        while (start <= end) {                      
            int mid = start + (end - start) / 2;

            if (isPossible(nums, n, m, mid)) {      
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] nums, int n, int m, int maxPages) { 
        int pageSum = 0;
        int studentCount = 1;                      

        for (int i = 0; i < nums.length; i++) {
            if (pageSum + nums[i] <= maxPages) {    
                pageSum += nums[i];
            } else {
                studentCount++;
                if (studentCount > m || nums[i] > maxPages) { 
                    return false;
                }
                pageSum = nums[i];                  
            }
        }

        return true;
    }
}
