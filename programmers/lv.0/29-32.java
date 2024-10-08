

// 피자 나눠 먹기 (3)
// 피자 조각 수(slice)와 피자를 먹는 사람의 수(n)를 이용하여 피자를 주문해야 하는 최소 피자 판 수
class Solution_29 {
    public int solution(int slice, int n) {
      int pizza = 0;
        if(n%slice == 0)
        {
            pizza = n/slice;
        }
        else {
            pizza = n/slice + 1;
        }

        return pizza;
    }
}
/* 
만약 n을 slice로 나눈 나머지가 0이라면
피자 판 수는 n을 slice로 나눈 몫과 같음
이 경우는 n명의 사람이 각각 한 조각씩 먹는 경우
그렇지 않은 경우, 피자 판 수는 n을 slice로 나눈 몫에 1을 더한 값이 되어야 한다.
n명의 사람이 최소 한 조각 이상을 먹어야 하므로, 하나의 조각이 더 필요한 경우이다.
*/


// 짝수 홀수 개수

class Solution30_1 {
    public int[] solution(int[] num_list) {
        int evenCount = 0;
        int oddCount = 0;
        
        // num_list를 반복하여 짝수와 홀수 개수 계산
        for (int num : num_list) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        // 결과를 배열에 저장
        int[] result = {evenCount, oddCount};
        
        return result;
    }
}


// 우아 이렇게 푸신 분 대단...! 간결하면서 더 효율적인 듯!!   
class Solution30_2 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for(int i = 0; i < num_list.length; i++)
            answer[num_list[i] % 2]++;

        return answer;
    }
}

class Solution_암호_해독 {
    public String solution(String cipher, int code) {

        // StringBuilder를 사용하여 결과 문자열 생성
        StringBuilder answer = new StringBuilder();
        
        // code의 배수 번째 문자 가져오기
        for (int i = code - 1; i < cipher.length(); i += code) {
            answer.append(cipher.charAt(i));
        }
        
        // StringBuilder 객체를 문자열로 변환해서 반환
        return answer.toString();
    }
}

class Solution_대문자와_소문자 {
    public String solution(String my_string) {

        StringBuilder result = new StringBuilder();

        // 문자열의 각 문자 순회하기
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            // 문자가 대소문자 확인하고 변환
            if (Character.isUpperCase(c)) {
                // 대문자 -> 소문자 변환
                result.append(Character.toLowerCase(c));
            } else {
                // 소문자 -> 대문자 변환
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }
}