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

        TreeNode init = new TreeNode();

        // 1. Create a parent hashmap for every node usign BFS

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr == target)
                    init = curr;

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

        int level = -1;

        q.clear();

        q.offer(init);

        visited.add(init);

        boolean set = false;

        while (!q.isEmpty()) {

            int size = q.size();

            level += 1;

            List<Integer> currList = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                int curr_value = curr.val;

                currList.add(curr_value);

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

            if (level == k) {

                return currList;

            }

        }

        return res;

    }

}