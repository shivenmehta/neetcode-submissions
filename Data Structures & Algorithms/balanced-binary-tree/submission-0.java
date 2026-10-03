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
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBalanced;
    }

    public int helper (TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = helper(current.left);
        int right = helper(current.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(left,right);
    }
}
