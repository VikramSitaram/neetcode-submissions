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
    public boolean isBalanced(TreeNode root) {
        //check balance
        if (getHeightBalance(root) == -1) {
            return false;
        }
        return true;
    }

    private int getHeightBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftBalance = getHeightBalance(root.left);
        if (leftBalance == -1) {
            return -1;
        }
        int rightBalance = getHeightBalance(root.right);
        if (rightBalance == -1) {
            return -1;
        }

        if (Math.abs(leftBalance - rightBalance) > 1) {
            return -1;
        }

        return Math.max(leftBalance, rightBalance) + 1;
    }
}
