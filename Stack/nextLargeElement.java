
// Improper Solution and not the defined result value. (Need to use Stack)
class Solution {
    public int[] nextLargerElement(int[] arr) {

        int[] proArray = new int[arr.length];

    for(int i = 0; i < arr.length; i++){
        proArray[i] = -1;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] > arr[i]){
                proArray[i] = arr[j];
                break;
            }

        }
    }
    return proArray;
    
    }
}
