class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {

        int[] array = new int[2];
        int n = nums.length;
        Arrays.sort(nums);

                int repeatingIndex = -1;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                array[0] = nums[i];
                repeatingIndex = i;
                break;
            }
         }


       array[1] = findMissing(nums, n, repeatingIndex);


       return array;



    }
//issue is the XOR? Goal should be to solve them by oneself.
    public static int findMissing(int[] k, int n, int skipIndex) {
        int xor = 0;
        
        // XOR all array elements
        for (int i = 0; i < k.length; i++) {
            if(i == skipIndex){
                continue;
            }
            xor ^= k[i];
        }
        
        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        
        return xor; // Result is the missing number
    }


}
