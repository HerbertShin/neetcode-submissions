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
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        findKthSmallest(root, tmp);
        return tmp[1];
    }

    private void findKthSmallest(TreeNode node, int[] tmp) {
        if (node == null || tmp[0] == 0) return;

        findKthSmallest(node.left, tmp);
        tmp[0] -= 1;

        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }

        findKthSmallest(node.right, tmp);
    }
}
