import java.util.Arrays;

class Solution {
    public static void sortColors(int[] nums) {
        int low = 0;           // for 0 (red)
        int mid = 0;           // current index
        int high = nums.length - 1; // for 2 (blue)

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                mid++; // white is in correct place
            } 
            else { // nums[mid] == 2
                // swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }

    // Testing
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {2, 0, 1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
