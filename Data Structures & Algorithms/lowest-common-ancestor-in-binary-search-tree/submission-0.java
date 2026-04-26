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
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, TreeNode> nodes = new HashMap<>();
        call(root, -101, parents, nodes);
        // System.out.println("parents "+parents);
        // System.out.println("nodes "+nodes);
        List<Integer> pA = new ArrayList<>();
        backtrack(p.val, parents, pA);
        List<Integer> qA = new ArrayList<>();
        backtrack(q.val, parents, qA);
        
        // System.out.println("pA "+pA);
        // System.out.println("qA "+qA);
        int lca = root.val;
        int i = pA.size()-1;
        int j = qA.size()-1;
        while (true) {
            if (i >=0 && j>=0 && pA.get(i) == qA.get(j)){
                lca = pA.get(i);
                i--;
                j--;
            }else{
                break;
            }            
        }
        return nodes.get(lca);
    }

    void call(TreeNode root, int parent, Map<Integer, Integer> parents, Map<Integer, TreeNode> nodes) {
        if (root == null) {
            return;
        }
        parents.put(root.val, parent);
        nodes.put(root.val, root);
        call(root.left, root.val, parents, nodes);
        call(root.right, root.val, parents, nodes);        
    }
    void backtrack(int val, Map<Integer, Integer> parents, List<Integer> ancestry){
        if (val == -101) {
            return;
        }
        ancestry.add(val);
        backtrack(parents.get(val), parents, ancestry);
    }
}
