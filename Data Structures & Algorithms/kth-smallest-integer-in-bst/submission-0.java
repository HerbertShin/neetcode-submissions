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
        List<Integer> flattenedBST = new ArrayList<>();

        traverseBST(root, flattenedBST);

        return flattenedBST.get(k - 1);
    }

    private void traverseBST(TreeNode root, List<Integer> flattenedBST) {
        if (root == null) return;

        if (root.left != null) {
            traverseBST(root.left, flattenedBST);
        }

        flattenedBST.add(root.val);

        if (root.right != null) {
            traverseBST(root.right, flattenedBST);
        }
    }
}
