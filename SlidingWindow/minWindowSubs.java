//Improvement and fixing of hashMap
import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int left = 0;
        int length = map.size();
        int size = 0;
        
        int minVal = Integer.MAX_VALUE;
        int minLeft = 0;

        HashMap<Character, Integer> windowmap = new HashMap<>();
        
        for(int right = 0; right < s.length(); right++){
            
            char ch = s.charAt(right); 
            windowmap.put(ch, windowmap.getOrDefault(ch, 0)+1);
        
            if(map.containsKey(ch) && windowmap.get(ch).equals(map.get(ch))){
                size++;
            }
            
            while(size == length){
                int currlength = right - left + 1;
                
                if (currlength < minVal) {
                minVal = currlength;
                minLeft = left;
                
                }

                char leftChar = s.charAt(left);

            windowmap.put(leftChar, windowmap.get(leftChar)- 1);
            if(map.containsKey(leftChar) && windowmap.get(leftChar) < map.get(leftChar)){
                size--;
            }
               left++;
            }
        }

    if (minVal == Integer.MAX_VALUE) {
    return "";
} 
    else {
        return s.substring(minLeft, minLeft + minVal);
}


    }
}

class Solution {
  public String minWindow(String s, String t) {

    if (t == null || t.length() == 0 || s.length() == 0 || s == null) {
      return " ";
    }

    HashMap<Character, Integer> tmap = new HashMap<>();

    for (char c : t.toCharArray()) {
      tmap.put(c, tmap.getOrDefault(c, 0) + 1);
    }

    int i = 0;
    int j = 0;
    int left = 0;
    int right = s.length() - 1;
    int count = tmap.size();
    int min = s.length();
    boolean isFound = false;

    while (j < s.length()) {
      char endChar = s.charAt(j++);
      if (tmap.containsKey(endChar)) {
        tmap.put(endChar, tmap.get(endChar) - 1);
        if (tmap.get(endChar) == 0) count -= 1;
      }
      if (count > 0) {
        continue;
      }

      while (count == 0) {
        char startChar = s.charAt(i++);
        if (tmap.containsKey(startChar)) {
          tmap.put(startChar, tmap.get(startChar) + 1);
          if (tmap.get(startChar) > 0) count += 1;
        }
      }

      if ((j - i) < min) {
        left = i;
        right = j;
        min = j - i;
        isFound = true;
      }
    }
    return !isFound ? "" : s.substring(left - 1, right);
  }
}
