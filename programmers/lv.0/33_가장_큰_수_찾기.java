// https://school.programmers.co.kr/learn/courses/30/lessons/120899

class Solution {
    public int[] solution(int[] array) {
      int maxNumber = array[0]; // 초기화: 첫 번째 요소로 최대값 설정
        int maxIndex = 0;         // 초기화: 첫 번째 요소의 인덱스 설정
        
        // 배열 순회 시작 (첫 번째 요소는 이미 사용했으므로 두 번째 요소부터 시작)
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i]; // 더 큰 수가 발견되면 최대값 갱신
                maxIndex = i;         // 해당 인덱스도 갱신
            }
        }
        return new int[] {maxNumber, maxIndex}; // 결과 배열 반환
    }
}