// Error laden code, needs further debugging

class Solution {
    
    class TrieNode{
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    void insert(int num){
        TrieNode curr = root;
        for(int i = 31; i >=0; i--){
            int bit = (num >> i) & 1;
        if(curr.children[bit] == null){
            curr.children[bit] = new TrieNode();

        }
        curr = curr.children[bit];

        }
       
    }

    public int getMax(int num){
        TrieNode curr = root;
        int maxXOR = 0;

        for(int i = 31; i >=0; i--){
            int bit = (num >> i) & 1;
            int opposite = 1-bit;

            if(curr.children[opposite] != null){
                maxXOR |= (1 << i);
                curr = curr.children[opposite];
            }
            else{
                curr = curr.children[bit];
            }
        }
        return maxXOR;

    }

    public int findMaximumXOR(int[] nums) {
        if(nums.length == 1) return 0;

       for(int num: nums){
        insert(num);
       }

       int result = 0;
       for(int num:nums){
        result = Math.max(num, getMax(result));
       }

       return result;
    }
}
