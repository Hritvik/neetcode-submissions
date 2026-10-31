class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (int i = 0; i < strs.size(); i++){
            String prefix = String.valueOf(strs.get(i).length());
            if (prefix.length() == 1) {
                prefix = "00"+prefix;
            } else if(prefix.length() == 2) {
                prefix = "0"+prefix;
            } 
            result = result + prefix + strs.get(i);
        }
        return result;
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < str.length()){
            int length = Integer.valueOf(str.substring(i, i+3));
            String word = str.substring(i+3, i + 3 + length);
            i = i + 3 + length;
            result.add(word);
        }
        return result;
    }
}
