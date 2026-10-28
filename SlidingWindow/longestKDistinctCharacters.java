class Solution {
    public int kDistinctChar(String s, int k) {
        
        int n = s.length();
        int left = 0;
        int length = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.size() > k){
                char d = s.charAt(left);
                map.put(d, map.getOrDefault(d,0)-1);

            if(map.get(d) == 0){
                map.remove(d);
            }
            left++;
            }
            
            length = Math.max(right-left+1, length);
            
        }

        return length;
    }
}
