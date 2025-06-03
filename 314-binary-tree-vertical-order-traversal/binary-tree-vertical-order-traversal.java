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
    
    class Node {
        TreeNode node;
        int hd;

        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int minHD = Integer.MAX_VALUE, maxHD = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            hm.putIfAbsent(curr.hd, new ArrayList<>());
            hm.get(curr.hd).add(curr.node.val);
            minHD = Math.min(minHD, curr.hd);
            maxHD = Math.max(maxHD, curr.hd);

            if (curr.node.left != null) q.offer(new Node(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) q.offer(new Node(curr.node.right, curr.hd + 1));
        }

        for (int i = minHD; i <= maxHD; i++) {
            res.add(hm.get(i));
        }

        return res;
    }
}