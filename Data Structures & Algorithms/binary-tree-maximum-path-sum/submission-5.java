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
    public int maxPathSum(TreeNode root) {        
        TreeSet<Integer> ts = new TreeSet<>((a, b)->{
            return -Integer.compare(a,b);
        });
        recursive(root, ts);
        System.out.println(ts);
        return ts.first();
    }

    int recursive(TreeNode root, TreeSet<Integer> ts){
        int c = root.val;        
       
        if (root.right !=null && root.left !=null){
            int l = recursive(root.left, ts);
            int r = recursive(root.right, ts);
            int max = Math.max(c,Math.max(Math.max(c+r, c+l), c+r+l));
            int max2 = Math.max(c,Math.max(c+r, c+l));
            ts.add(max);
            ts.add(l);
            ts.add(r);
            ts.add(c);
            return max2;            
        } else if (root.left !=null){
            int l = recursive(root.left, ts);
            int max = Math.max(c, c+l);
            ts.add(max);
            ts.add(l);
            ts.add(c);
            return max;
        } else  if (root.right !=null){
            int r = recursive(root.right, ts);
            int max = Math.max(c, c+r);
            ts.add(max);
            ts.add(r);
            ts.add(c);
            return max;
        } else {
            ts.add(c);
            return c;
        }
    }
}
