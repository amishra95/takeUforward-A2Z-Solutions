class Solution {
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    heights[j] = 0;
                }
                else
                heights[j]++;
            }
            maxArea = Math.max(maxArea, largeRectArea(heights));
        }
     return maxArea;
     
    }
    private int largeRectArea(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1: stack.peek();
                int width = i - left -1;
                maxArea = Math.max(maxArea, h*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = n- left-1;
            maxArea = Math.max(maxArea, h*width);
        }
        return maxArea;
    }

    
}
