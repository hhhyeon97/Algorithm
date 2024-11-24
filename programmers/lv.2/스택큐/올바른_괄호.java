
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

// 카운터 풀이
// O(n): 문자열을 한 번 순회하며 괄호를 검사하므로 길이에 비례함
class Solution {
    boolean solution(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++; // 여는 괄호일 경우 증가
            } else {
                count--; // 닫는 괄호일 경우 감소
                if (count < 0) {
                    return false; // 닫는 괄호가 더 많으면 올바르지 않음
                }
            }
        }

        // 최종적으로 count가 0이면 올바른 괄호, 아니면 false
        return count == 0;
    }
}

// 실행 예제
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("()()"));    // true
        System.out.println(solution.solution("(())()"));  // true
        System.out.println(solution.solution(")()("));    // false
        System.out.println(solution.solution("(()("));    // false
    }
}

// 스택 풀이
// O(n): 문자열을 한 번 순회하며 각 문자에 대해 push/pop을 수행하므로 선형 시간
// import java.util.Stack;

// class Solution2 {
//     boolean solution(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 stack.push(c); // 여는 괄호는 스택에 추가
//             } else {
//                 if (stack.isEmpty()) {
//                     return false; // 닫는 괄호가 더 많으면 false
//                 }
//                 stack.pop(); // 닫는 괄호가 나오면 스택에서 하나 제거
//             }
//         }

//         // 순회 후 스택이 비어 있으면 true, 남아 있으면 false
//         return stack.isEmpty();
//     }
// }