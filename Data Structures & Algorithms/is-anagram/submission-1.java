class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++ ) {
            m.compute(s.charAt(i), (k, v)-> {
                if (v == null) {
                    return 1;
                }else {
                    if (v == -1) {
                        return null;
                    } else {
                    return v+1;}
                }
            });
            // System.out.println(m);
            m.compute(t.charAt(i), (k, v)-> {
                if (v == null) {
                    // System.out.println("x "+k);
                    return -1;
                } else {
                    if (v == 1) {
                        // System.out.println("y "+k);
                        return null;
                    } else {
                        // System.out.println("z "+k);
                        return v-1;
                    }
                }
            });
            // System.out.println(m);
        }
       
        if (m.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
