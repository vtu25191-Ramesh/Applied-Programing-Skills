import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new LinkedList<>(); // decreasing deque
        Deque<Integer> minD = new LinkedList<>(); // increasing deque

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain max deque (decreasing)
            while (!maxD.isEmpty() && nums[right] > maxD.peekLast()) {
                maxD.pollLast();
            }
            maxD.addLast(nums[right]);

            // Maintain min deque (increasing)
            while (!minD.isEmpty() && nums[right] < minD.peekLast()) {
                minD.pollLast();
            }
            minD.addLast(nums[right]);

            // Shrink window if condition violated
            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (nums[left] == maxD.peekFirst()) {
                    maxD.pollFirst();
                }
                if (nums[left] == minD.peekFirst()) {
                    minD.pollFirst();
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
