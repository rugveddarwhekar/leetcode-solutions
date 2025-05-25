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
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode currP = s1.pop();
            TreeNode currQ = s2.pop();
            if (currP == null && currQ == null) {
                continue;
            }
            if (currP == null || currQ == null) {
                return false;
            }
            if (currP.val != currQ.val) {
                return false;
            }
            s1.push(currP.left);
            s2.push(currQ.left);
            s1.push(currP.right);
            s2.push(currQ.right);
        }

        return true;
    }
}