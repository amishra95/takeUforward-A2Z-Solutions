 class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int count = 0;

    for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == '0'){
                int localCount = 0;
            
            for(int col = j-1; col >= 0 && grid[i][col] != 'W'; col--){
                if(grid[i][col] == 'E'){
                    localCount++;
                }
            }

            for(int col = j+1; col < grid[0].length && grid[i][col] != 'W'; col++){
                if(grid[i][col] == 'E'){
                    localCount++;
                }
            }
             for(int row = i - 1; row >= 0 && grid[row][j] != 'W'; row--){
                        if(grid[row][j] == 'E') localCount++;
                    }

                
            for(int row = i + 1; row < grid.length && grid[row][j] != 'W'; row++){
                        if(grid[row][j] == 'E') localCount++;
                    }

            count = Math.max(count, localCount);

            }


            }
        }

        return count;
    

    
    }
}
