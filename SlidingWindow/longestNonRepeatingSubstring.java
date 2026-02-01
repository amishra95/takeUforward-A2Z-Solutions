class Solution {
    public int longestNonRepeatingSubstring(String s) {
        
        //"abcddabac" Solve this? How 
    HashSet<Character> set = new HashSet<>();
    
    int maxLength = 0;
    int end = 0;
    int length = s.length();
    
    for(int start = 0; start< s.length(); start++){

        if(!set.contains(s.charAt(start))){
            set.add(s.charAt(start));
            maxLength = Math.max(maxLength, start-end+1);
        }   
        else{
            while(set.contains(s.charAt(start))){
                set.remove(s.charAt(end));
                end++;

            }
            set.add(s.charAt(start));
        }

    }
    return maxLength;

    }
}
