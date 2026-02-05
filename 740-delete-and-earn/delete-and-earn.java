class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        int take = 0, skip = 0;

        for (int i = 0; i <= max; i++) {
            int takeNew = skip + sum[i];
            int skipNew = Math.max(skip, take);
            take = takeNew;
            skip = skipNew;
        }

        return Math.max(take, skip);
    }
}
