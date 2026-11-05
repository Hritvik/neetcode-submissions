class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length -1;
        int max = 0;
        while (i<j) {
            int m = Math.min(heights[i], heights[j]) * (j-i);
            max = Math.max(m, max);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
