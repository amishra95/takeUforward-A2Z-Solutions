/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       
       StringBuilder sb = new StringBuilder();
       helper(root, sb);
       return sb.toString();
    
    }

    public void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(',');
        helper(root.left, sb);
        helper(root.right, sb);
       
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return build(q);

    }
    private TreeNode build(Queue<String> q){
        String t = q.poll();
        if (t.equals("#")) return null;
        TreeNode node  = new TreeNode(Integer.parseInt(t));
        node.left = build(q);
        node.right = build(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
