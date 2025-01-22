
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

//  최대 이익 계산하기 -> 매수와 매도를 결정
//  매수일이 매도일보다 앞서야 한다.

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // 최소값 갱신
            if (price < minPrice) {
                minPrice = price;
            } 
            // 최대 이익 갱신
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}