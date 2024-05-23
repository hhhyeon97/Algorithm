
import java.util.*;

// 스택/큐

// 같은 숫자는 싫어


class Solution1_1 {
    public int[] solution(int []arr) {
       ArrayList <Integer> arrList = new ArrayList<>();
        
        int num =-1;
        
        for(int i=0; i<arr.length; i++){
            if(num != arr[i]){
                arrList.add(arr[i]);
                num = arr[i];   
                }
        }
        
        int[] answer = new int[arrList.size()];
                 for (int j = 0; j < arrList.size(); j++){
             answer[j] = arrList.get(j);

         }

        return answer;
    }
}

/*
ai 피드백

사용자가 작성하신 자바 코드에서는 `num` 변수를 사용하여 연속된 숫자를 필터링하려고 하셨네요.
하지만, 여기서 문제가 발생합니다. 배열의 첫 번째 원소를 `num`에 할당하는 로직이 빠져 있습니다.
따라서 배열의 첫 번째 숫자가 무조건 0이 아니라면 그 숫자를 건너뛰게 됩니다.
예를 들어, 입력 배열이 [4,4,4,3,3]일 때, 첫 번째 '4'가 결과 리스트에 추가되지 않습니다.
이를 해결하기 위해, 초기 `num` 값을 설정할 때 배열의 첫 번째 원소를 사용하는 것이 아닌,
배열에서 존재할 수 없는 값을 초기값으로 설정해야 합니다. 
예를 들어 `-1`과 같이 이 문제에서 주어진 0~9 범위 밖의 값을 사용하는 것이 좋겠죠.
그러면 모든 `num`과 배열의 첫 번째 원소가 항상 다르게 되므로 
첫 번째 원소를 정상적으로 결과 리스트에 추가할 수 있습니다.
이 점을 고려하여 코드를 수정해 보세요.
 */


// 다른 분 풀이 

class Solution1_2 {
     public int[] solution(int []arr) {
      ArrayList<Integer> tempList = new ArrayList<Integer>();
         int preNum = 10;
         for(int num : arr) {
             if(preNum != num)
                 tempList.add(num);
             preNum = num;
         }       
         int[] answer = new int[tempList.size()];
         for(int i=0; i<answer.length; i++) {
             answer[i] = tempList.get(i).intValue();
         }
         return answer;
     }
 } 



// Valid Parentheses ( LeetCode  )
// 괄호 문자열이 유효한지 판단하는 문제

class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
        
        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            // 여는 괄호는 스택에 추가
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫는 괄호일 경우
                // 스택이 비어있거나, 스택의 최상단이 짝이 맞지 않는 경우
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        // 모든 괄호를 처리하고 스택이 비어있으면 유효한 문자열
        return stack.isEmpty();
    }

// 여는 괄호와 닫는 괄호가 짝이 맞는지 확인하는 메서드
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

}

/*
스택 사용: 스택을 사용하여 여는 괄호 저장
여는 괄호 처리: 여는 괄호 '(', '{', '['를 만나면 스택에 추가
닫는 괄호 처리: 닫는 괄호 ')', '}', ']'를 만나면 스택에서 
               최상단 요소를 꺼내서 짝이 맞는지 확인
스택이 비어있거나 짝이 맞지 않으면 유효하지 않은 문자열로 간주
모든 문자를 처리한 후 스택이 비어있다면 유효한 문자열인 것 !
*/

 