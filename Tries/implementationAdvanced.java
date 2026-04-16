class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    int countEndsWith = 0;
    int countPrefix = 0;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        
    }

    public void insert(String word) {

    TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            curr.countPrefix++;
        }
        curr.countEndsWith++;
        
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)- 'a';
            if(curr.children[index] == null){
                return 0;
            }
            
        curr = curr.children[index];
        }

       return  curr.countEndsWith;
    }


    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i)- 'a';
            if(curr.children[index] == null){
                return 0;
            }
            curr = curr.children[index];

        }
        return curr.countPrefix;
    }

    public void erase(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)- 'a';
            if(curr.children[index] == null){
                return ;
            }
            curr = curr.children[index];  
                curr.countPrefix--;            

        }
        curr.countEndsWith--;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
