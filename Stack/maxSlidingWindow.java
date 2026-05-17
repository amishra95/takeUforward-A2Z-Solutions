class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int i = 0; i < n; i++) {

            maxHeap.offer(new int[]{arr[i], i});

            while (maxHeap.peek()[1] < i - k + 1) {
                maxHeap.poll();
            }

            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}

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
