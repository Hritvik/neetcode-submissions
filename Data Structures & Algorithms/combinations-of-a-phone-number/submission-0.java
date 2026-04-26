class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> dict = new HashMap<>();
        dict.put("2", Arrays.asList("a", "b", "c"));
        dict.put("3", Arrays.asList("d", "e", "f"));
        dict.put("4", Arrays.asList("g", "h", "i"));
        dict.put("5", Arrays.asList("j", "k", "l"));
        dict.put("6", Arrays.asList("m", "n", "o"));
        dict.put("7", Arrays.asList("p", "q", "r", "s"));
        dict.put("8", Arrays.asList("t", "u", "v"));
        dict.put("9", Arrays.asList("w", "x", "y", "z"));        
        String[] split = digits.split("");
        List<String> result = new ArrayList<>();
        recursive(split,0, result, dict, "");
        return result;
    }
    void recursive(String[] split, int index, List<String> result, Map<String, List<String>> dict, String append){
        if (index < split.length) {
            List<String> chars = dict.get(split[index]);
            // System.out.println(chars);
            for (String c : chars) {
                recursive(split, index+1, result,dict, append+c);
            }
        } else {
            result.add(append);
        }
    }
}
