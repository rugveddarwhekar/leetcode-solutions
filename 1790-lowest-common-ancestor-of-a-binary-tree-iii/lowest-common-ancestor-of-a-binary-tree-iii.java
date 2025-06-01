/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;

        Set<Node> hs = new HashSet<>();
        while (b != null) {
            hs.add(b);
            b = b.parent;
        }

        while (a != null) {
            if (hs.contains(a)) return a;
            a = a.parent;
        }

        return a;
    }
}