class Solution {
    public List<List<String>> partition(String s) {
       // The solution arc of result wrt String and String case.
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;

           
    }

    public void backtrack(String s, int index, List<String> current, List<List<String>> result){
        //Definitive base case for recursive loop
        if(index == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                current.add(s.substring(index, i+1));
                backtrack(s, i+1, current, result);
                current.remove(current.size()-1);
            }

        }
    }

    public boolean isPalindrome(String s, int left, int right){
           while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
           }
        return true;
    }
}
