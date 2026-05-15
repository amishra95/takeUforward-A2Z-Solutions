class Solution {
       public String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if (digits.length() == 0) return list;
        backtrack(digits, list, 0, "");
        return list;
    }

    public void backtrack(String digits, List<String> list, int index, String current) {

        if (index == digits.length()) {
            list.add(current);
            return;
        }

        String s = map[digits.charAt(index) - '0'];

        for (int i = 0; i < s.length(); i++) {
            backtrack(digits, list, index + 1, current + s.charAt(i));
        }
    }
}
