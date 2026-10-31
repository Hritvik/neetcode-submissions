class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p = 0;
        int q = numbers.length-1;
        while (p>=0 && p<numbers.length && q>=0 && q<numbers.length) {
            // System.out.println(p+" "+q);
            if (numbers[p]+numbers[q]<target){
                p++;
            } else if (numbers[p]+numbers[q]>target){
                q--;
            } else if (numbers[p]+numbers[q]==target){
                int[] ans = new int[2];
                ans[0] = p+1;
                ans[1] = q+1;
                return ans;
            }
        }
        return numbers;
    }
}
