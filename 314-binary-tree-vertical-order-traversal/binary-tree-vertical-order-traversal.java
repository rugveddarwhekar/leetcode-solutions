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

    private class Node {
        TreeNode node;
        int hd;

        private Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            map.putIfAbsent(curr.hd, new ArrayList<>());
            map.get(curr.hd).add(curr.node.val);
            minHd = Math.min(minHd, curr.hd);
            maxHd = Math.max(maxHd, curr.hd);

            if (curr.node.left != null) q.offer(new Node(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) q.offer(new Node(curr.node.right, curr.hd + 1));
        }

        for (int i = minHd; i <= maxHd; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}