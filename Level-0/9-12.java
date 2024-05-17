import java.util.Arrays; // 10번 문제에 필요


// 나머지 구하기

class Solution9 {
    public int solution(int num1, int num2) {
        int answer = num1%num2;
        return answer;
    }
}

// 중앙값 구하기

class Solution10 {
    public int solution(int[] array) {
         Arrays.sort(array); // 배열을 오름차순으로 정렬
        int middleIndex = array.length / 2; // 중앙 인덱스 계산 (정수 나눗셈은 자동으로 내림 처리됨)
        return array[middleIndex]; // 중앙값 반환
    }
}