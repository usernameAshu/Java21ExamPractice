package interview_prep.DSA_Leetcode.leetcode.array_strings;

/**
 * LeetCode 121
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class Best_Time_Buy_Sell_Stock {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int maxProfit = new Best_Time_Buy_Sell_Stock().maxProfit(prices);

        System.out.println(maxProfit);
    }

    /**
     * Approach: https://www.youtube.com/watch?v=1pkOgXD63yU
     * Two pointer approach, where buy pointer will stay at low point,
     * At positive profit, we will store the max profit
     * At negative profit, we will move buy to sell index
     * sell pointer will increase throughout.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int L = prices.length;
        if (L < 2) return 0;
        int b = 0, s= 1, maxProfit = 0;

        while(s < L) {
            if(prices[b] < prices[s]) {
                //profit
                maxProfit = Math.max(prices[s] - prices[b], maxProfit);
            } else {
                b = s;
            }

            s++;
        }
        return maxProfit;
    }

    //TLE (Time Limit Exceeded)
    public int maxProfit_2(int[] prices) {
        int L = prices.length;
        if (L < 2) return 0;
        int b = 0;
        int s = 1;
        int p = 0;

        while (s < L && b < L - 1) {
            p = Math.max(prices[s] - prices[b], p);

            if (prices[b] > prices[b + 1]) b++;
            if (s == L - 1 && b < L - 2) {
                b++;
                s = b + 1;
            } else {
                s++;
            }
        }
        return p;
    }

}
