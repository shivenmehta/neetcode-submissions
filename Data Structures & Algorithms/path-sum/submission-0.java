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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode current, int targetSum, int currentSum) {

        if (current == null) {
            return false;
        }

        int newSum = currentSum + current.val;

        if (current.left == null && current.right == null) {
            if (newSum == targetSum) return true;
        }
        
        boolean leftBool = helper(current.left, targetSum, newSum);
        boolean rightBool = helper(current.right, targetSum, newSum);

        return (leftBool || rightBool);

    }   
}