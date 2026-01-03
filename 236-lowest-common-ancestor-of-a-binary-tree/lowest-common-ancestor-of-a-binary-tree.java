/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Stack
        Stack<TreeNode> stack = new Stack<>();

        // HashMap
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();

        stack.push(root);
        hm.put(root, null);

        // Iterate over tree
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null) {
                hm.put(curr.left, curr);
                stack.push(curr.left);
            }
            if (curr.right != null) {
                hm.put(curr.right, curr);
                stack.push(curr.right);
            }
        }

        // Declare HashSet
        HashSet<TreeNode> hs = new HashSet<>();

        // Iterate over parents of p
        while (p != null) {
            hs.add(p);
            p = hm.get(p);
        }

        // Iterate over parents of q and compare
        while (!hs.contains(q)) {
            q = hm.get(q);
        }

        return q;
    }
}