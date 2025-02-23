
// https://school.programmers.co.kr/learn/courses/30/lessons/181936

class Solution {
    public int solution(int number, int n, int m) {
        
        if(number % n == 0 && number % m == 0){
            return 1;
        }else {
            return 0;
        }
    }
}

// 삼항 연산자 사용하면 더 간단하게 표현 가능
class Solution1 {
    public int solution(int number, int n, int m) {
        return number % n == 0 && number % m == 0 ? 1 : 0;
    }
}