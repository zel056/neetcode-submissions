class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //the result array length
        //Hashing; key is the number, and the value represents the times it shows in the array; >= 
        Map<Integer,Integer> map = new HashMap();
        int[] result = new int[k];
        List<Integer> [] order = new List[nums.length+1];
        for (int i=0; i<nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for (Integer key: map.keySet()){
            if (order[map.get(key)]==null){
                order[map.get(key)] = new ArrayList<>();
            }
            order[map.get(key)].add(key);
        }

        int placeholder = 0;
        for (int i = order.length - 1; i >= 0 && placeholder < k; i--) {
            if (order[i] != null) {
                for (int element : order[i]) {
                    result[placeholder++] = element;
                    if (placeholder == k) break;
                }
            }
        }
        return result;

    }
}
