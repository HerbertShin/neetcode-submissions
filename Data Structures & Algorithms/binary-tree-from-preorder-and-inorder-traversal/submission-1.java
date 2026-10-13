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
        Map<Integer, Integer> midMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            midMap.put(inorder[i], i);
        }

        return build(preorder, inorder, midMap);
    }

    private TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);

        Integer mid = map.get(preorder[0]);

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, mid);

        root.left = buildTree(preorderLeft, inorderLeft);

        int[] preorderRight = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        root.right = buildTree(preorderRight, inorderRight);

        return root;
    }

}
