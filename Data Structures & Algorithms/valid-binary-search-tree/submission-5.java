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
    public boolean isValidBST(TreeNode root) {
        return checkValidity(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkValidity(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (node.val > min && node.val < max) {
            return checkValidity(node.left, min, node.val) && checkValidity(node.right, node.val, max);
        }

        return false; 
    }
}
