//@newsolution 
class Solution {
    public int candy(int[] ratings) {
    
    int n = ratings.length;
    int count = 0;

    int[] arr = new int[n];

    Arrays.fill(arr, 1);

    for(int i = 1; i < n; i++){
       if(ratings[i] > ratings[i-1]){
            arr[i] = arr[i-1] +1;
       }
    }
    for(int i = n-2; i >= 0; i--){
        if(ratings[i] > ratings[i+1]){
            arr[i] = Math.max(arr[i], arr[i+1]+1);
        }
    }

    for(int b : arr){
        count += b;
    }
   


return count;

        

    }
}


class Solution {
    public int candy(int[] ratings) {
       //dynamic programming case and needed condition
    int count = 0;
    int n = ratings.length;
    if(n== 0) 
    return 0;
    
    int[] a = new int[n];
    Arrays.fill(a, 1);
    
    for(int i=1; i < n; i++){
        if(ratings[i] > ratings[i-1]){
            a[i] = a[i-1]+1;
        }
    }

    for(int i = n-2; i >=0; i--){
        if(ratings[i]> ratings[i+1]){
            a[i] = Math.max(a[i], a[i+1]+1);
        }
    }
    
    for(int c: a){
        count += c;
    }

return count;


    }
}
