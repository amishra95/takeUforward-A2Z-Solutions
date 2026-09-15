class Solution {
    public List<Integer> findBuildings(int[] heights) {

     int n = heights.length;
     List<Integer> list = new ArrayList<>();
     int maxHeight = -1;

    for(int i = n-1; i>= 0; i--){
        if(heights[i] > maxHeight){
            list.add(i);
            maxHeight = heights[i];
        }
    }
    Collections.reverse(list);
    return list;

    }
}
