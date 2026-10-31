class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num: nums){
            m.merge(num,1, Integer::sum);
        }
        List<Integer> starting = new ArrayList<>();
        for (int num: nums){
            if (!m.containsKey(num-1)){
                starting.add(num);
            }
        }
        int max=0;
        for (int start: starting) {
            int i = 0;
            while (m.containsKey(start)){
                start++;
                i++;
            }
            max = Math.max(max,i);
        }
        return max;
    }
}
