class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            m.put(nums[i], i);
        }
        // System.out.println(m);
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (m.containsKey(diff) && m.get(diff) != i) {
                // System.out.println(diff);
                int j = m.get(diff);
                int s = Math.min(i, j);
                int l = Math.max(i, j);
                int[] r = new int[2];
                r[0] = s;
                r[1] = l;
                return r;
            }
        }
        return nums;
    }
}
