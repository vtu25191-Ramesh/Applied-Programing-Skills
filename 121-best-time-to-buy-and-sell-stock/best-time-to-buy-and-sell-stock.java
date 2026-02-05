class Solution {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // update minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // calculate profit if sold today
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // Testing
    public static void main(String[] args) {
        System.out.println(maxProfit(
                new int[]{7, 1, 5, 3, 6, 4})); // 5

        System.out.println(maxProfit(
                new int[]{7, 6, 4, 3, 1})); // 0
    }
}
