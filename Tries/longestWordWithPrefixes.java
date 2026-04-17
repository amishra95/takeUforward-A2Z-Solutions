class Solution {

    class TrieNode{
         TrieNode[] children = new TrieNode[26];
         int countEndsWith = 0;

    }
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

        curr = curr.children[index];
        }
        curr.countEndsWith++;
    }

    public boolean prefixExist(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
             if(curr.children[index] == null){
                return false;
             }
             curr = curr.children[index];
             if(curr.countEndsWith == 0){
                return false;
             }
        }
        return true;
    }


    public String completeString(List<String> nums) {

        for(String word: nums){
            insert(word);
        }

        String result = "";

        for(String word:nums){
            if(prefixExist(word)){
                if(word.length() > result.length()){
                    result = word;
                }
                else if(word.length() == result.length() && word.compareTo(result)< 0){
                        result = word;
                }
            }
        }
                
        return result;
    }
}
