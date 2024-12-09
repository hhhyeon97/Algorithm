
// https://school.programmers.co.kr/learn/courses/30/lessons/131705

// 삼중 반복문 사용 -> 시간복잡도 : O(n^3)
// 조건에서 배열의 길이가 최대 13이므로
// 13^3 = 2197으로 실행 시간은 허용 범위 내이다.

class Solution {
    public int solution(int[] number) {
        // ex) number = [-2, 3, 0, 2, -5]
        
        int count = 0; // 삼총사의 수를 세는 변수
        
        // 3중 반복문으로 세 개의 숫자를 선택
        // ㄴ> 
        // 배열에서 서로 다른 3개의 숫자를 선택해서 
        // 이들의 합이 0이 되는지를 확인하기 위함.
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    // 선택한 세 숫자의 합이 0인 경우
                    if (number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count; // 결과 반환
        // 2 (삼총사 조합: [-2, 0, 2], [3, 2, -5])
    }
}