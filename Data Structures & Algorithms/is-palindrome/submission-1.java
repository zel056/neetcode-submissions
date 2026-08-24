class Solution {
    public boolean isPalindrome(String s) {
        String word = s.replaceAll("[^a-zA-Z0-9]", "");
        word = word.toLowerCase();
        int tail = word.length();
        for (int header =0; header<word.length()/2;header++){
            if (word.charAt(header)!=word.charAt(tail-1-header)){
                return false;
            }
        }

        return true;
    }
}
