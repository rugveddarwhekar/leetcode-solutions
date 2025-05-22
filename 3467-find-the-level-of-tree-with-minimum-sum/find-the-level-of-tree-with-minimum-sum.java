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
    public int minimumLevel(TreeNode root) {
        int level = 0;
        long minLevelSum = Integer.MAX_VALUE;
        int minLevel = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long currSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currSum += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            level++;
            if (currSum < minLevelSum) {
                minLevelSum = currSum;
                minLevel = level;
            }
        }        
        return minLevel;
    }
}