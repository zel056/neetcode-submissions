class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        int longest =0;

        for (int num: nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            }
        }

        for (Integer key: map.keySet()){
            if (!map.containsKey(key-1)){
                int curr = key;
                int length =1;

                while (map.containsKey(curr+1)){
                    curr++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }

        return longest;
    }
}
