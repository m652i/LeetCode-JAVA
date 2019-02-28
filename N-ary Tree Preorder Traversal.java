/*

Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

Return its preorder traversal as: [1,3,5,6,2,4].

*/

========================================================================================

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
========================================================================================

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        if(root == null) return list;
        stack.push(root);
        
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            for(int i = root.children.size()-1; i >= 0 ; i--) {
                stack.push(root.children.get(i));
            }
        }
       return list;
        
        
    }
}
