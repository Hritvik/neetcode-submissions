class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        for (int x : nums){
            m.put(x, true);
        }
        if (m.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}