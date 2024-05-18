import java.util.*;

// 배열 자르기

class Solution17_1 {
    public int[] solution(int[] numbers, int num1, int num2) {
        // 선택한 부분의 길이 계산
        int length = num2 - num1 + 1;
        
        // 새로운 배열 생성
        int[] answer = new int[length];
        
        // 선택한 부분의 요소를 복사
        for (int i = num1; i <= num2; i++) {
            answer[i - num1] = numbers[i];
        }
        
        return answer;
    }
}

// 다른 분 풀이 copyOfRange 메서드는 처음 알았다 싱기

class Solution17_2 {
    public int[] solution(int[] numbers, int num1, int num2) {
       return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}

// 중복된 숫자 개수

class Solution18 {
    public int solution(int[] array, int n) {
         int count = 0;
        
        // 배열을 순회하면서 n이 등장한 횟수 세기
        for (int num : array) {
            if (num == n) {
                count++;
            }
        }
        return count;
    }
}


// 머쓱이보다 키 큰 사람

class Solution19 {
    public int solution(int[] array, int height) {
        int count = 0;
        for(int num:array){
            if(num>height){
                count++;
            }
        }
        return count;
    }
}

// 각도기

class Solution20 {
    public int solution(int angle) {
      if (angle > 0 && angle < 90) { 
            return 1;
        } else if (angle == 90) { 
            return 2;
        } else if (angle > 90 && angle < 180) {
            return 3;
        } else if (angle == 180) {
            return 4;
        } else {
            return -1;
        }
    }
}