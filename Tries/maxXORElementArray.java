import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode curr = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    public int getMax(int num) {
        TrieNode curr = root;
        int maxXOR = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (curr.children[opposite] != null) {
                maxXOR |= (1 << i);
                curr = curr.children[opposite];
            } else if (curr.children[bit] != null) {
                curr = curr.children[bit];
            } else {
                return -1;
            }
        }
        return maxXOR;
    }

    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        
        // Reset root for the current problem execution
        root = new TrieNode();

        // 1. Sort nums and prepare offline queries
        Arrays.sort(nums);
        List<int[]> offlineQueries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            // mi (limit), xi (value), original index
            offlineQueries.add(new int[]{queries[i][1], queries[i][0], i});
        }

        // 2. Sort queries by the limit mi
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        int numsIdx = 0;
        for (int[] query : offlineQueries) {
            int mi = query[0];
            int xi = query[1];
            int originalIdx = query[2];

            // 3. Add numbers to Trie that satisfy the mi constraint
            while (numsIdx < nums.length && nums[numsIdx] <= mi) {
                insert(nums[numsIdx]);
                numsIdx++;
            }

            // 4. Calculate Max XOR or assign -1 if no numbers were inserted
            if (numsIdx != 0) {
                ans[originalIdx] = getMax(xi);
            } else {
                ans[originalIdx] = -1;
            }
        }

        // 5. Convert int array to List<Integer>
        List<Integer> result = new ArrayList<>();
        for (int val : ans) {
            result.add(val);
        }
        return result;
    }
}
