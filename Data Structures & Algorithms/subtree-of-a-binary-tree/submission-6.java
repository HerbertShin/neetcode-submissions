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

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (isSame(node, subRoot)) return true;

            if (node.left != null) {
                stack.push(node.left);
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        

        q1.add(root);
        q2.add(subRoot);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            int size = q1.size();

            for (int i = 0; i < size; i ++) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();

                if (n1 == null && n2 == null) continue;

                if (n1 == null || n2 == null || n1.val != n2.val) return false;

                q1.add(n1.left);
                q1.add(n1.right);
                q2.add(n2.left);
                q2.add(n2.right);
            }
        }

        return true;
    }
}
