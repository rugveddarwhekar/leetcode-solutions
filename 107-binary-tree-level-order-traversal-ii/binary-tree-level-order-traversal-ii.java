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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            for(int i = q.size(); i > 0; --i) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    arr.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            if (arr.size() > 0)
                res.add(0, arr);
        }

        return res;
    }
}