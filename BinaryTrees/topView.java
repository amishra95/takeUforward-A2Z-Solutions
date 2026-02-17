import java.util.*;

public class BinaryTreeTopView {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Pair to track node with its horizontal distance
    static class NodeHD {
        Node node;
        int hd;
        NodeHD(Node node, int hd) { this.node = node; this.hd = hd; }
    }

    public static List<Integer> topView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap keeps HDs sorted (leftmost to rightmost)
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<NodeHD> queue = new LinkedList<>();

        queue.add(new NodeHD(root, 0));

        while (!queue.isEmpty()) {
            NodeHD curr = queue.poll();
            int hd = curr.hd;
            Node node = curr.node;

            // Only record the FIRST node seen at each horizontal distance
            if (!hdMap.containsKey(hd)) {
                hdMap.put(hd, node.data);
            }

            if (node.left != null)  queue.add(new NodeHD(node.left,  hd - 1));
            if (node.right != null) queue.add(new NodeHD(node.right, hd + 1));
        }

        result.addAll(hdMap.values());
        return result;
    }

    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            / \ / \
           4  5 6  7
        */
        Node root = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left   = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Top View: " + topView(root));
        // Output: [4, 2, 1, 3, 7]
    }
}
