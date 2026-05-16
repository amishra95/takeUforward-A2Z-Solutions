class Solution {
    public int[] JobScheduling(int[][] Jobs) {
    
        int n = Jobs.length;

        Arrays.sort(Jobs, Comparator.comparingInt((int[] job) -> job[2]).reversed());

        int maxDeadline = 0;
        for(int[] job : Jobs){
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int countJobs = 0;
        int totalProfit = 0;

        for(int[] job : Jobs){
            for(int j = job[1]; j >= 1; j--){
                if(slot[j] == -1){
                    slot[j] = job[0];
                    countJobs++;
                    totalProfit += job[2];
                    break;
                }
            }
        }

        return new int[]{countJobs, totalProfit};
    }
}
