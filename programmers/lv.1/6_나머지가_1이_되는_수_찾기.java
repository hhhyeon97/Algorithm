
// https://school.programmers.co.kr/learn/courses/30/lessons/87389

/*n % x == 1이 성립하는 x 찾기
ㄴ> 
x = 1부터 시작해서 
n % x == 1을 만족하는 첫 번째 x를 찾으면 된다.
*/

class Solution {
    public int solution(int n) {
        // 1부터 n-1까지 반복하면서 n % x == 1인 x를 찾음
        for (int x = 1; x < n; x++) {
            if (n % x == 1) {
                return x; // 조건을 만족하는 x를 반환
            }
        }
        return -1; // 이 코드는 실행되지 않음 (문제에서 답이 항상 존재한다고 했으므로)
    }
}