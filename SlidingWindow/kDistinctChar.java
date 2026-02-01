class Solution {
  public int kDistinctChar(String s, int k) {

    int n = s.length();
    int length = 0;
    int left = 0;

    HashMap<Character, Integer> map = new HashMap<>();

    for(int right = 0; right < n; right++) {
      char rightChar = s.charAt(right);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

      while (map.size() > k) {
        char leftChar = s.charAt(left);
        map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
      

      if (map.get(leftChar) == 0) {
        map.remove(leftChar);
      }

      left++;
    }
        length = Math.max(length, right - left + 1);
    }

    return length;
  }
}
