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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            for (int i = 0; i < q1.size(); i++) {
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
