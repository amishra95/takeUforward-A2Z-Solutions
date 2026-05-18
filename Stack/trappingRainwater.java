class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int left = 0; 
        int right = n-1;
       
        int maxLeft = 0;
        int maxRight = 0;
        int count =0;

        while(left <= right){
            if(maxLeft <= maxRight){
            maxLeft = Math.max(maxLeft,height[left]);
            count += maxLeft - height[left];
            left++;
            }

        else{
            maxRight = Math.max(maxRight, height[right]);
            count += maxRight - height[right];
            right--;
        }
      

        }

    return count;
}

}
