class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            left[i] = max;
            // System.out.print(left[i] + " ");
            max = Math.max(max, height[i]);
        }
        // System.out.println();
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        // for (int i = 0; i < height.length; i++) {
        //     System.out.print(right[i] + " ");
        // }
        // System.out.println();
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int wall = Math.min(left[i], right[i]);
            if (wall > height[i]) {
                total += (wall - height[i]);
            }
        }
        return total;
    }
}
