class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while (j>i){
            char left = s.charAt(i);
            char right = s.charAt(j);
            // System.out.println(left+ " vs "+right);
            if (!((left >= 'a' && left <= 'z') || (left >= 'A' && left <= 'Z') || (left >= '0' && left <= '9'))){
                i++;
                continue;
            }
            if (!((right >= 'a' && right <= 'z') || (right >= 'A' && right <= 'Z') || (right >= '0' && right <= '9'))){
                j--;
                continue;
            }
            if (left == right) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
