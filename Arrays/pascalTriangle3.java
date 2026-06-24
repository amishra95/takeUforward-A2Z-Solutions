class Solution {
    public List<List<Integer>> pascalTriangleIII(int n) {
       
     
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }
        
        return pascalTriangle;


    }

    public List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> list = new ArrayList<>();

        list.add(1);
        for(int col = 1; col < row; col++){
            ans = ans *(row-col);
            ans = ans/col;
            list.add((int) ans);
        }

        return list;
    }

}
