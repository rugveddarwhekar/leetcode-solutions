/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int maxDiameter = 0;

    public int diameter(Node root) {
        longestPath(root);
        return maxDiameter;
    }

    private int longestPath(Node node) {
        if (node == null) return 0;
        int max1 = 0;
        int max2 = 0;
        List<Node> nodeChildren = node.children;
        for (Node child: nodeChildren) {
            int currLen = longestPath(child);
            if (currLen >= max1) {
                max2 = max1;
                max1 = currLen; 
            } else if (currLen > max2) {
                max2 = currLen;
            }
        }
        maxDiameter = Math.max(maxDiameter, max1 + max2);

        return Math.max(max1, max2) + 1;
    }
}