/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    sb.append("N,");
                } else {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        } 

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;

        String[] arr = data.split(",");

        if (arr[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!arr[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(arr[index]));
                queue.add(node.left);
            }
            
            index ++;
            
            if (!arr[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(arr[index]));
                queue.add(node.right);
            }
            
            index ++;
        }

        return root;
    }
}
