
// https://school.programmers.co.kr/learn/courses/30/lessons/120836

// 순서쌍 개수 구하기

// ex) n = 20
// 곱이 20인 순서쌍은
// (1, 20), (2, 10), (4, 5), (5, 4), (10, 2), (20, 1)
// 결과로 개수인 6을 반환한다.

// 두 숫자의 곱이 n인 자연수 순서쌍의 개수 = n의 약수 개수

class Solution {
    public int solution(int n) {
        
       int count = 0;
        
       for (int i = 1; i <= n; i++) {
    		if(n%i==0) {
    			count++;
    		}
		}

    	return count; 
    }
}