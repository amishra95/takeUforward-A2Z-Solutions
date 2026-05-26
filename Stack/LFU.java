class LFUCache {

    class Node {
        int key, val, count;
        Node prev, next;

        public Node(int k, int v) {
            key = k;
            val = v;
            count = 1;
        }
    }

    class DLList {
        Node head, tail;
        int length;

        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            length = 0;
        }

        public void addHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            length++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            length--;
        }

        public Node removeTail() {
            if (length == 0) return null;   // guard: empty list
            Node prevTail = tail.prev;
            remove(prevTail);
            return prevTail;                // return evicted node so caller can clean up map
        }
    }

    Map<Integer, DLList> freq;
    Map<Integer, Node>   map;
    int capacity, size, minFreq;           // minFreq replaces the broken maxFreq eviction logic

    public LFUCache(int capacity) {
        freq     = new HashMap<>();
        map      = new HashMap<>();
        this.capacity = capacity;
        size     = 0;
        minFreq  = 0;
    }

    // ── promote a node's frequency by 1 ──────────────────────────────────────
    private void promote(Node node) {
        int prevFreq = node.count;
        DLList prevList = freq.get(prevFreq);
        prevList.remove(node);

        // if this was the last node at minFreq, the minimum rises
        if (prevFreq == minFreq && prevList.length == 0) minFreq++;

        node.count++;                      // FIX: was "node.count;" (no-op)
        int curFreq = node.count;

        DLList curList = freq.getOrDefault(curFreq, new DLList());
        curList.addHead(node);
        map.put(node.key, node);           // keep map entry current

        freq.put(prevFreq, prevList);
        freq.put(curFreq,  curList);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        promote(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {        // update existing key
            map.get(key).val = value;
            promote(map.get(key));
            return;
        }

        // evict LFU tail before inserting when at capacity
        if (size == capacity) {
            DLList minList = freq.get(minFreq);
            Node evicted = minList.removeTail();
            if (evicted != null) {
                map.remove(evicted.key);   // FIX: map cleanup belongs here, not inside DLList
                size--;
            }
        }

        // insert brand-new node at frequency 1
        Node node = new Node(key, value);
        DLList curList = freq.getOrDefault(1, new DLList());
        curList.addHead(node);
        map.put(key, node);
        freq.put(1, curList);
        minFreq = 1;                       // new node always resets minimum to 1
        size++;
    }
}
