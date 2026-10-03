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
        return DepthHelper(root);
    }

    public int DepthHelper(TreeNode current) {

        if (current == null) {
            return 0;
        }
        
        return Math.max(1 + DepthHelper(current.left), 1 + DepthHelper(current.right));
        
    }
}
