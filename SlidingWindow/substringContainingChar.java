class Solution {    
    public int numberOfSubstrings(String s) {
       int count = 0;

       int[] a = {-1, -1, -1};

       for(int right = 0; right < s.length(); right++){
            a[s.charAt(right)-'a'] = right;
       
        if(a[0] != -1 && a[1] != -1 && a[2] != -1){
            count += 1+ Math.min(a[0], Math.min(a[1], a[2]));
        }
       
    }
    
    return count;

    }
}
