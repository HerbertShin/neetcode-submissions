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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        int mid = -1; 
        
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                mid = i;
                break;
            }
        }

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, mid);

        root.left = buildTree(preorderLeft, inorderLeft);

        int[] preorderRight = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }
}
