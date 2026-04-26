class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        TreeMap<Integer, Integer> f = new TreeMap<>();
        for (int c: candidates) {
            f.compute(c, (k,v)-> {
                if (v == null) {
                    return 1;
                } else {
                    return v+1;
                }
            });
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> append = new ArrayList<>();
        recursive(f, target, result, append);
        return result;
    }

    void recursive(TreeMap<Integer, Integer> f, int target, List<List<Integer>> result, List<Integer> append){
        // System.out.println(f+" "+target);
        if (target == 0) {
            result.add(new ArrayList<>(append)); 
            return;
        }
        if (f.size() == 0 || target < 0) {
            return;
        }        
        int key = f.firstEntry().getKey();
        int val = f.firstEntry().getValue();
        remove(f, key);        
        append.add(key);
        recursive(f, target - key, result, append);        
        f.remove(key);
        append.remove(append.size()-1);
        recursive(f, target, result, append);
        f.put(key,val);
    }

    void remove(Map<Integer, Integer> f, int x){
        f.compute(x, (k,v)-> {
                if (v - 1 == 0) {
                    return null;
                } else {
                    return v-1;
                }
            });
    }

}
