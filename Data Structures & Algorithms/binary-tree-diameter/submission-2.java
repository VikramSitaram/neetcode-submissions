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
    int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        // get height and track diameter
        getHeightAndTrackDiameter(root);
        return diameter;
    }

    private int getHeightAndTrackDiameter(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeightAndTrackDiameter(root.left);
        int rightHeight = getHeightAndTrackDiameter(root.right);

        int heightAtNode = leftHeight + rightHeight;
        diameter = Math.max(diameter, heightAtNode);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
