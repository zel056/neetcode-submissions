class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);

        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);

        s = new String (sArr);
        t = new String (tArr);

        if (s.equals(t)){
            return true;
        }

        return false;
    }
}
