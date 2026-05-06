class Solution {
    public int findMedian(int[][] matrix) {
    
    int[] arr = flatten(matrix);
    Arrays.sort(arr);
    int n = arr.length;

    if(n %2 == 1){
        return (int)arr[n/2];
    }
    else{
        return (int)(arr[n/2-1] + arr[n/2])/2;

    }
    }


public int[] flatten(int[][] matrix) {
    int size = 0;
    for (int[] row : matrix) {
        size += row.length;
    }

    int[] result = new int[size];
    int index = 0;
    for (int[] row : matrix) {
        for (int element : row) {
            result[index++] = element;
        }
    }
    return result;
}

}
