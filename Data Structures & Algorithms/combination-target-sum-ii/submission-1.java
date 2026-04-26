class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> f = new TreeMap<>();
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

    void recursive(Map<Integer, Integer> f, int target, List<List<Integer>> result, List<Integer> append){
        // System.out.println(f+" "+target);
        if (target == 0) {
            result.add(append);
            return;
        }
        if (f.size() == 0 || target < 0) {
            return;
        }
        TreeMap<Integer, Integer> nf1 = new TreeMap<>(f);
        int val = nf1.firstEntry().getKey();
        remove(nf1, val);
        List<Integer> appendCopy = new ArrayList<>(append);
        appendCopy.add(val);
        recursive(nf1, target - val, result, appendCopy);
        TreeMap<Integer, Integer> nf2 = new TreeMap<>(f);
        nf2.remove(val);
        recursive(nf2, target, result, append);
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
