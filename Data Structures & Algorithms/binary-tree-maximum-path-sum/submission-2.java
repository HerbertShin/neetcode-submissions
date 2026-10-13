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
    public int maxPathSum(TreeNode root) {
        AtomicInteger res = new AtomicInteger(root.val);
        dfs(root, res);
        return res.get();
    }

    private int dfs(TreeNode root, AtomicInteger res) {
        if (root == null) return 0;

        int left = Math.max(dfs(root.left, res), 0);
        int right = Math.max(dfs(root.right, res), 0);

        res.set(Math.max(res.get(), root.val + left + right));

        return root.val + Math.max(left, right);
    }
}
