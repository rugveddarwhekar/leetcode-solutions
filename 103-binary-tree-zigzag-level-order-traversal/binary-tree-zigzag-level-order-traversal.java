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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    if (level % 2 == 0) {
                        arr.add(curr.val);
                    } else {
                        arr.add(0, curr.val);
                    }
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            level += 1;
            if (arr.size() > 0) 
                res.add(arr);
        }

        return res;
    }
}