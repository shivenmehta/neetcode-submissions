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
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode current) {

        if (current == null) {
            return;
        }
        invertTreeHelper(current.left);
        invertTreeHelper(current.right);

        TreeNode leftNode = current.left;
        TreeNode rightNode = current.right;
        current.left = rightNode;
        current.right = leftNode;
    }
}
