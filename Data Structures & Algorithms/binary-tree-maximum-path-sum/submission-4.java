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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            return -Integer.compare(a,b);
        });
        recursive(root, pq);
        // System.out.println(pq);
        return pq.poll();               
    }

    int recursive(TreeNode root, PriorityQueue<Integer> pq){
        int c = root.val;        
       
        if (root.right !=null && root.left !=null){
            int l = recursive(root.left, pq);
            int r = recursive(root.right, pq);
            int max = Math.max(c,Math.max(Math.max(c+r, c+l), c+r+l));
            int max2 = Math.max(c,Math.max(c+r, c+l));
            pq.add(max);
            pq.add(l);
            pq.add(r);
            pq.add(c);
            return max2;            
        } else if (root.left !=null){
            int l = recursive(root.left, pq);
            int max = Math.max(c, c+l);
            pq.add(max);
            pq.add(l);
            pq.add(c);
            return max;
        } else  if (root.right !=null){
            int r = recursive(root.right, pq);
            int max = Math.max(c, c+r);
            pq.add(max);
            pq.add(r);
            pq.add(c);
            return max;
        } else {
            pq.add(c);
            return c;
        }
    }
}
