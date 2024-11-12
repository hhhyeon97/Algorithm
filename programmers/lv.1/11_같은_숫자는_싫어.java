
// https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
         // 연속된 중복 숫자를 제거하여 저장할 리스트 생성
         List<Integer> list = new ArrayList<Integer>();
        
         // 이전 숫자를 저장할 변수 N 초기화 
         // (초기값은 임의의 숫자, 여기선 10 사용)
         int N = 10;
         
         // arr 배열을 순회하며 연속된 중복 숫자 제거
         for(int num: arr) {
             // 현재 숫자가 이전 숫자(N)와 다르면 리스트에 추가
             if(N != num) {
                 list.add(num);
             }
             // N을 현재 숫자로 업데이트하여 다음 비교 준비
             N = num;
         }
 
         // 리스트의 요소를 배열로 변환하여 결과 저장
         int[] answer = new int[list.size()];
         for(int i = 0; i < answer.length; i++) {
             answer[i] = list.get(i).intValue(); // Integer 객체를 기본 자료형 int로 변환해주는 메서드
         }
         
         // 결과 배열 반환
         return answer;
    }
}

/*
answer[i] = list.get(i).intValue(); 이렇게 한 이유는 List<Integer>의 요소들이 Integer 객체 타입이기 때문이다.
int 배열 answer에 값을 넣기 위해 Integer 객체를 기본 자료형 int로 변환해야 하는데, intValue()가 그 역할을 한다. 
이 과정이 필요한 이유는 기본 자료형(int)과 객체 타입(Integer) 간의 차이 때문이다.
다만, Java의 자동 언박싱(autounboxing) 덕분에 intValue() 없이도 Integer를 int로 변환할 수 있다. 
따라서 아래처럼 간단히 작성할 수도 있다.
ㄴ> answer[i] = list.get(i); // 자동 언박싱으로 int로 변환
이렇게 하면 Java가 intValue()를 자동으로 호출해 준다.
*/

/*
ArrayList와 List의 차이점
List<Integer>는 인터페이스 타입이고, 
ArrayList<Integer>는 그 구현 클래스다.
List<Integer>로 선언하면, 구현 방식을 유연하게 변경할 수 있다. 
예를 들어 LinkedList나 다른 List 구현체로 쉽게 바꿀 수 있다. 
반면, ArrayList<Integer>로 선언하면 ArrayList에 종속된다.
따라서, 코딩 시 List<Integer>로 선언하고 생성 시에 ArrayList<>를 사용하는 것이 관례다.
*/


// 다른 풀이 - stack 활용

/*
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       // 연속 중복 숫자를 제거하기 위해 스택을 사용
        Stack<Integer> stack = new Stack<>();
        
        // arr 배열을 순회하며 스택에 중복되지 않는 숫자만 추가
        for (int num : arr) {
            // 스택이 비어 있지 않고
            // 스택의 최상단 숫자가 현재 숫자와 같으면 중복이므로 건너뛰기
            if (!stack.isEmpty() && stack.peek() == num) {
                continue;
            }
            // 스택이 비어 있거나, 최상단 숫자가 현재 숫자와 다르면 스택에 추가
            stack.push(num);
        }
        
        // 스택에 있는 숫자를 결과 배열로 변환
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();  // 스택에서 역순으로 꺼내서 배열에 저장
        }
        
        return answer;
    }
}
*/