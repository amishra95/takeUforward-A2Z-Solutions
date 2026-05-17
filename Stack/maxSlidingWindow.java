//TLE ( needs improvement from the Brute Force structure)
class Solution {
  public int[] maxSlidingWindow(int[] arr, int k) {

    int n = arr.length;
    List<Integer> b = new ArrayList<>();

    for (int i = 0; i <= n - k; i++) {
      int maxi = arr[i];

      for (int j = i; j < i + k; j++) {
        maxi = Math.max(maxi, arr[j]);
      }
      b.add(maxi);
    }
    int[] array = b.stream().mapToInt(Integer::intValue).toArray();

    return array;
  }
}
