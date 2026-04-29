// Sorted solution, Higher Space and Time Complexity
class Solution {
    public int kthElement(int[] a, int[] b, int k) {
      
      int n = a.length;
      int m = b.length;
        int[] result = new int[n+m];

    for(int i = 0; i < n; i++){
        result[i] = a[i];
    }
    for(int i =0; i < m; i++){
        result[n+i] = b[i];
    }

    Arrays.sort(result);

    return result[k-1];


    }

}
