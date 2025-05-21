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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode init = new TreeNode();

        // 1. Initial BFS to build the parent hashmap and figure the init node
        q.offer(root);
        parent.put(root, root);
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode curr = q.poll();
                if (curr.val == start) init = curr;
                if (curr.left != null) {
                    parent.put(curr.left, curr);
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    parent.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }
        }

        // 2. Second BFS starting from init to find the max level / min time
        q.clear();
        q.offer(init);
        visited.add(init);
        int time = -1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode curr = q.poll();
                TreeNode p = parent.get(curr);
                if (!visited.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
            }
            time++;
        }

        return time;
    }
}