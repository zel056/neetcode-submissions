class Solution {
    public int search(int[] nums, int target) {
        int head = 0; 
        int tail = nums.length - 1; 
        int result = -1; 
        
        while (head < tail) { 
            int medium = head + (tail - head) / 2; 
            
            if (target < nums[medium]) { 
                if (nums[medium] > nums[tail] && target <= nums[tail]) { 
                    head = medium + 1; 
                } else { 
                    tail = medium; 
                } 
            } else if (target > nums[medium]) { 
                if (nums[medium] > nums[tail] || target <= nums[tail]) { 
                    head = medium + 1; 
                } else { 
                    tail = medium; 
                } 
            } else { 
                return medium; 
            } 
        } 
        
        if (nums.length > 0 && nums[head] == target) { 
            result = head; 
        } 
        return result;
    }
}
