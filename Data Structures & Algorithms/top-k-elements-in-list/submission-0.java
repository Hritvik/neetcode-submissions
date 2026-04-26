class Solution {
    public int[] topKFrequent(int[] nums, int target) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, List<Integer>> m2 = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            m1.compute(nums[i], (k, v)-> {
                if (v == null) {
                    return 1;
                } else {
                    return v+1;
                }
            }); 
        }
        // System.out.println(m1);
        for (int key : m1.keySet()) {
            int f = m1.get(key);
            m2.compute(f, (k, v)-> {
                if (v == null) {
                    List<Integer> l = new ArrayList<>();
                    l.add(key);
                    return l;
                } else {
                    v.add(key);
                    return v;
                }
            });
        }
        // System.out.println(m2);
        int[] r = new int[target];
        int j = target;
        int[] keys = new int[m2.size()]; 
        int p = 0;
        for (int f : m2.keySet()) {
            keys[m2.size()-(p++) - 1] = f;
        }
        for (int f : keys) {
            for (int val: m2.get(f)){
                if (j > 0) {
                    r[target-j] = val;
                } 
                j--;        
            }
        }       
        return r;
    }
}
