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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        
        helper(root);
        return maxDiameter;
        
    }

    public int helper(TreeNode current) {

        if (current == null) {
            return 0;
        }

        int left = helper(current.left);
        int right = helper(current.right);

        int diameter = left + right;
        if (diameter > maxDiameter) maxDiameter = diameter;

        return 1 + Math.max(left, right); // return height


    }

    // public int helper(TreeNode root, TreeNode current, ArrayList<Integer> lengths, int balance) {
    //     if (current == null) {
    //         return 0;
    //     }

    //     lengths.add(balance);
    //     System.out.println(balance);
        
    //     balance = balance - 1 + helper(root, current.left, lengths, balance);

    //     if (current == root) {
    //         balance = 0;
    //     }

    //     balance += 1 + helper(root, current.right, lengths, balance);

    //     return 0;
        
    // }

}
