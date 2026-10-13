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
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) return depth;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();

            TreeNode node = pair.getKey();
            Integer currDepth = pair.getValue();

            if (node != null) {
                depth = Math.max(depth, currDepth);
                stack.push(new Pair(node.left, currDepth + 1));
                stack.push(new Pair(node.right, currDepth + 1));
            }
        }

        return depth;
    }
}
