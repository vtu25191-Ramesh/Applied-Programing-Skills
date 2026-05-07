import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store current number with index
            map.put(nums[i], i);
        }
        
        return new int[] {}; // No solution (though problem guarantees one)
    }
}