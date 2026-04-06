class Solution {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {
       
        int n = arr.length;    
        int dp[] = new int[n];
        int parent[] = new int[n];


        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIndex = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIndex = i;
            }

        }

        List<Integer> list = new ArrayList<>();
        int i = lastIndex;
        while(i != -1){
            list.add(arr[i]);
            i = parent[i];  
            
        }
        
        Collections.reverse(list);

        return list;
    

    }
}
