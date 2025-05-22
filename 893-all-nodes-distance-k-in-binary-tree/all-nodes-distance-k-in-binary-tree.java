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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        // 1. Create a parent hashmap for every node usign BFS
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
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

        // 2. BFS starting from init till we reach k-th level
        int level = 0;
        q.clear();
        q.offer(target);
        visited.add(target);

        if (k == 0) {
            res.add(target.val);
            return res;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode p = parent.get(curr);
                if (p != null && !visited.contains(p)) {
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
            level++;
            if (level == k) {
                while (!q.isEmpty()) {
                    res.add(q.poll().val);
                }
                return res;
            }
        }

        return res;
    }
}