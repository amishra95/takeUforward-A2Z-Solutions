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
