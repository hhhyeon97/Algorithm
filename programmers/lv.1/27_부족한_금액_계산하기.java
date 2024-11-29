
// https://school.programmers.co.kr/learn/courses/30/lessons/82612

class Solution {
    public long solution(int price, int money, int count) {
        
        // 필요한 총 비용 계산
        long totalCost = 0;
        
        for (int i = 1; i <= count; i++) {
            totalCost += (long) price * i; // 가격 * 횟수를 누적
        }
        
        // 금액 부족분 계산
        long deficit = totalCost - money;
        
        // 부족하지 않으면 0 반환
        return deficit > 0 ? deficit : 0;
    }
}