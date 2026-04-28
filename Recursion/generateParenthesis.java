class Solution {
    public List<String> generateParenthesis(int n) {
      
      List<String> help = new ArrayList<>();
      generate(0,0,n, "", help);
      return help;
    }

    public void generate(int open, int close, int n, String current, List<String> help){
        if(open == close && open+close == 2*n){
            help.add(current);
            return;
        }

        if(open < n){
            generate(open+1, close, n, current + '(', help);
        }
        if(close < open){
            generate(open, close+1, n, current + ')', help);
        }
    }
}
