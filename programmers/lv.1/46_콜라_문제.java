
// https://school.programmers.co.kr/learn/courses/30/lessons/132267

class Solution {
    public int solution(int a, int b, int n) {
        // a = 콜라를 받기 위해 마트에 줘야 하는 병 수
        // b = 빈 병 a개를 주면 받을 수 있는 병 수
        // n = 상빈이가 가지고 있는 빈 병 개수
        
        int totalCoke = 0; // 상빈쓰가 받은 총 콜라 수

        while (n >= a) { 
            int exchangeable = n / a; // 교환 가능한 병 수
            int newCoke = exchangeable * b; // 교환으로 받은 콜라 수
            totalCoke += newCoke; // 총 콜라 수 누적
            n = (n % a) + newCoke; // 남은 병 + 새로 받은 병
        }
        
        return totalCoke;
    }
}