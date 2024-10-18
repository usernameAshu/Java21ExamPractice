package interview_prep.dataStructures.leetcode.array_strings;

/**
 * LeetCode 122
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class Best_Time_Buy_Sell_Stock_II {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = new Best_Time_Buy_Sell_Stock_II().maxProfit(prices);

        System.out.println(maxProfit);
    }

    //Input: prices = [7,1,5,3,6,4]
    //output : (1,5), (3,6) => 7

    /**
     * Approach as Part 1 problem,
     * Only thing is that we need to sum up the positive profit,
     * and whenever we have a positve profit we need to increment the index of buy
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int L = prices.length;
        if (L < 2) return 0;
        int b = 0, s= 1, profit = 0;
        int totalProfit = 0;
        while(s < L) {
            if(prices[b] < prices[s]) {
                //profit
                System.out.println("Buy: "+ prices[b]+ ", Sell:"+ prices[s]);
                profit = prices[s] - prices[b];
                totalProfit += profit;
                b++;
            } else {
                b = s;
            }

            s++;
        }
        return totalProfit;
    }

}
