// Solved without using Xor ( Mostly sorted Array with O log(N);
class Solution {
  public int[] singleNumber(int[] nums) {

    Arrays.sort(nums);
    int[] array = new int[2];
    int index = 0;

    for (int i = 0; i < nums.length - 1; i += 2) {
      if (nums[i] != nums[i + 1]) {
        array[index] = nums[i];
        index++;
        i--;
      }
    }
    if (index < 2) {
      array[index] = nums[nums.length-1];
    }
    return array;
  }
}
