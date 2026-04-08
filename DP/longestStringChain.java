class Solution {
    //Adding real value in the number available, here?
    public int longestStringChain(String[] words) {

    Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int dp[] = new int[n];
    
        Arrays.fill(dp, 1);
int max = 0;
    
    for(int i = 0; i < n ; i++){
        for(int j = 0; j < i; j++){
            if(isPredecessor(words[j], words[i])){
                dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        max = Math.max(max, dp[i]);

    }
    return max;

    }

private boolean isPredecessor(String shorter, String longer) {
    if (longer.length() - shorter.length() != 1) return false;


    int i = 0, j = 0;
    while (i < shorter.length() && j < longer.length()) {
        if (shorter.charAt(i) == longer.charAt(j)) {
            i++;
        }
        j++;
    }

    return i == shorter.length();
}

}
