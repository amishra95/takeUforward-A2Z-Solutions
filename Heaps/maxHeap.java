class Solution {

    private List<Integer> list;
    private int count;

    public Solution(){
        list = new ArrayList<>();
        count = 0;
    }

    private void heapifyUp(int i){
        int parent = (i-1)/2;
        if(i > 0 && list.get(i) > list.get(parent)){
            int temp = list.get(i);
            list.set(i, list.get(parent));
            list.set(parent, temp);

            heapifyUp(parent);
        }

        return;

    }

    private void heapifyDown(int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

    if(left < count && list.get(left) > list.get(largest)){
        largest = left;
    }
    if(right < count && list.get(right) > list.get(largest)){
        largest = right;
    }

    if(largest != i){
        int temp = list.get(largest);
        list.set(largest, list.get(i));
        list.set(i, temp);
        heapifyDown(largest);
    }
    
    return;
    }

    public void initializeHeap() {
        list.clear();
        count = 0;
        
    }

    public void insert(int key) {
       list.add(key);
        count = count + 1;       
        heapifyUp(count - 1);

        return;
    }

    public void changeKey(int index, int newVal) {
        if(list.get(index) < newVal){
            list.set(index, newVal);
            heapifyUp(index);
        }
        else{
            list.set(index, newVal);
            heapifyDown(index);
        }
        return;
    }

    public void extractMax() {
        
        int k = list.get(0);
        int temp = list.get(count-1);
        list.set(0, temp);

        list.remove(count-1);
        count = count-1;
        if(count > 0){
            heapifyDown(0);
        }
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int getMax() {
     return list.get(0);  
    }

    public int heapSize() {
        return count;
    }
}
