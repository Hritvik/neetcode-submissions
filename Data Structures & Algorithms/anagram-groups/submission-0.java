class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, ArrayList<String>> m = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int h = hash(s);
            m.compute(h, (k,v) -> {
                if (v == null) {
                    ArrayList<String> l = new ArrayList<String>();
                    l.add(s);
                    return l;
                } else {
                    v.add(s);
                    return v;
                }
            });
        }
        // System.out.println(m);        
        return m.values().stream().collect(Collectors.toList());
    }

    int hash(String str){
        int s = 0;
        int m = 1;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            s += c;
            m *= c;
        }        
        return s * m;
    }

}
