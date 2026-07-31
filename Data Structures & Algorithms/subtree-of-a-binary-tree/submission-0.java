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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }

        // check if root and subroot are the same
        return (isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        // base cases
        if (root != null && subRoot == null) {
            return false;
        }
        if (root == null && subRoot != null) {
            return false;
        }
        if (root == null && subRoot == null) {
            return true;
        }

        // value check
        if (root.val != subRoot.val) {
            return false;
        }

        return (isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right));
    }
}
