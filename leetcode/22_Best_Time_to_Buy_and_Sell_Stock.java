
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

//  최대 이익 계산하기

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE; // 최소 주가를 초기값으로 설정 (무한대)
        int maxProfit = 0;  // 최대 이익 초기값은 0으로 설정

        // prices 배열 순회
        for (int price : prices) {
            // 최소값 갱신
            if (price < minPrice) {
                minPrice = price; // 현재 값이 더 작다면 최소값 갱신
            } 
            // 최대 이익 갱신
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // 현재 이익이 더 크다면 최대 이익 갱신
            }
        }
        /*
        ex )
        입력 : prices = [7,1,5,3,6,4]
        
        초기 상태:
        minPrice = Integer.MAX_VALUE (무한대 → 아직 최소값 없음)
        maxProfit = 0
        
        첫 번째 값: 7
        minPrice = 7 (처음 값이므로 최소값 갱신)
        maxProfit = 0 (이익 계산: 7 - 7 = 0, 그대로 유지)
        
        두 번째 값: 1
        minPrice = 1 (현재 값이 더 작으므로 갱신)
        maxProfit = 0 (이익 계산: 1 - 1 = 0, 그대로 유지)
        
        세 번째 값: 5
        minPrice = 1 (갱신 없음)
        이익 계산: 5 - 1 = 4 → maxProfit = 4로 갱신
        
        네 번째 값: 3
        minPrice = 1 (갱신 없음)
        이익 계산: 3 - 1 = 2 → maxProfit = 4 (더 크지 않으므로 유지)
        
        다섯 번째 값: 6
        minPrice = 1 (갱신 없음)
        이익 계산: 6 - 1 = 5 → maxProfit = 5로 갱신
        
        여섯 번째 값: 4
        minPrice = 1 (갱신 없음)
        이익 계산: 4 - 1 = 3 → maxProfit = 5 (더 크지 않으므로 유지)
        
        출력 : 5 
        */

        return maxProfit;
    }
}