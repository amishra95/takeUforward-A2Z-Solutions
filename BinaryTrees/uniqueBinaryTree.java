class Solution {
    public boolean uniqueBinaryTree(int a, int b) {
       if (a == 1 && b == 2){
        return true;
       }
        if(a == 2 && b == 2){
        return false;
       }
        if(a == 1 && b == 3){
            return false;
        }
        if(a == 1 && b == 1){
            return false;
        }
        if(a == 3 && b == 1){
            return false;
        }
        if(a == 3 && b == 3)
        {
            return false;
        }
    return true;
    }
}
