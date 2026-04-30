class Solution {
    public double median(int[] arr1, int[] arr2) {
        
    int[] merged = mergeArrays(arr1, arr2);
    int total = merged.length;

    if(total %2 == 1){
        return merged[total/2];
    }
    else{
        return (merged[total/2 -1] + merged[total/2])/2.0;
    }
    



    }
    
    public int[] mergeArrays(int[] a, int[] b){
        int n = a.length;
        int m = b.length;

        int i = 0; 
        int j = 0;

        int[] merge = new int[n+m];

        int k = 0;
        while(i < n && j < m){
            if(a[i] <= b[j]){
                merge[k++] = a[i++];

            }else{
                merge[k++] = b[j++];
            }
        }
        while (i < n) merge[k++] = a[i++];

        while (j < m) merge[k++] = b[j++];

        for (i = 0; i < n; ++i) 
                a[i] = merge[i];

        for (j = 0; j < m; ++j) 
                b[j] = merge[n + j];

        return merge;
    
    }
}
