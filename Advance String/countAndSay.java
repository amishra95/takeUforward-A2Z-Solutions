class Solution {
    public String countAndSay(int n) {
      
              String result = "1";
            for (int i = 1; i < n; i++) {
            result = generateString(result);
        }

        return result;
    }

    public String generateString(String s){
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < s.length()){
            char curr = s.charAt(i);
            int count = 1;

            while(i+count < s.length() && s.charAt(i + count) == curr){
                count++;
            }
            sb.append(count);
            sb.append(curr);

            i += count;
        }
        return sb.toString();
    }
}
