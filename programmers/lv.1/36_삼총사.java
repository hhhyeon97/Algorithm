
class Solution {
    public int solution(int[] number) {
       int count = 0; // 삼총사의 수를 세는 변수
        
        // 3중 반복문으로 세 개의 숫자를 선택
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
    }
}