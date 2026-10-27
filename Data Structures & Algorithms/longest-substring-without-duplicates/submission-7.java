class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();

        if (length==0){
            return 0;
        }
        int head =0;
        int tail = 0;
        int result = 1;
        int localL =0;

        HashSet<Character> set = new HashSet<>();

        while(tail<length){
            if (!set.contains(s.charAt(tail))){
                set.add(s.charAt(tail));
                localL++;
                tail++;
            }
            else{
                result = Math.max(result,localL);
                set.remove(s.charAt(head));
                head++;
                localL--;
            }
            
        }
        return Math.max(result,localL);
    }
}
