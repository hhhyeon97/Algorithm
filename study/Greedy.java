

// 키워드: 탐욕법(Greedy)

// 각 단계에서 가장 최적이라고 생각되는 선택을 함으로써
// 문제를 해결하는 방법

/*
체육복
https://school.programmers.co.kr/learn/courses/30/lessons/42862
*/

// 정확성 93.3 다른 방법으로 접근하기 
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
      // 여분의 체육복을 도난 당한 학생들과 겹치는 경우 제거
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) {
            if (!contains(reserve, l)) {
                lostList.add(l);
            }
        }
        
        for (int r : reserve) {
            if (!contains(lost, r)) {
                reserveList.add(r);
            }
        }
        
        int answer = n - lostList.size(); // 일단 도난당한 학생 수를 빼고 시작
        
        // 도난당한 학생들에게 여분의 체육복을 빌려주는 처리
        for (int l : lostList) {
            if (contains(reserveList, l - 1)) { // 이전 번호 학생이 여분의 체육복을 가지고 있는 경우
                reserveList.remove((Integer)(l - 1)); // 여분의 체육복을 빌려줌
                answer++; // 체육수업을 들을 수 있는 학생 수 증가
            } else if (contains(reserveList, l + 1)) { // 다음 번호 학생이 여분의 체육복을 가지고 있는 경우
                reserveList.remove((Integer)(l + 1)); // 여분의 체육복을 빌려줌
                answer++; // 체육수업을 들을 수 있는 학생 수 증가
            }
        }
        
        return answer;
    }
    
    // 배열에 특정 값이 포함되어 있는지 확인하는 메서드
    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
    
    // 리스트에 특정 값이 포함되어 있는지 확인하는 메서드
    private boolean contains(List<Integer> list, int target) {
        return list.contains(target);
    }
}


/*
1221. Split a String in Balanced Strings
https://leetcode.com/problems/split-a-string-in-balanced-strings/description/
*/
class Solution2 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balance++;
            } else {
                balance--;
            }
            
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }
}

/*
변수 초기화:

count: 균형 잡힌 문자열의 개수를 셀 변수입니다.
balance: 현재까지의 'L'과 'R'의 균형 상태를 나타낼 변수입니다.

문자열 순회:

문자열을 하나씩 순회하면서 현재 문자가 'L'인지 'R'인지 확인합니다.
'L'을 만나면 balance를 1 증가시키고, 'R'을 만나면 balance를 1 감소시킵니다.
balance가 0이 되는 순간, 균형 잡힌 문자열 하나를 찾았다는 의미이므로 count를 1 증가시킵니다.

결과 반환:

최종적으로 count를 반환합니다. 




탐욕법의 주요 특징은 각 단계에서 현재 상황에서 가장 좋은 선택을 하는 것입니다.
이 문제에서의 탐욕적 접근은 다음과 같습니다:

현 상태에서의 최적 선택: 문자열을 순회하면서 'L'과 'R'의 균형을 유지하고, balance가 0이 되는 시점마다 현재까지의 부분 문자열을 하나의 균형 잡힌 문자열로 간주합니다.
지역 최적해의 선택: balance가 0이 되는 순간을 발견할 때마다 그 순간까지의 문자열을 균형 잡힌 문자열로 분리하고, 새로운 균형 잡힌 문자열을 찾기 시작합니다.
전체 최적해 도출: 이러한 지역 최적해의 선택이 누적되어 전체 문자열을 최대한 많이 균형 잡힌 문자열로 분리할 수 있게 됩니다.

"해"는 주어진 문제나 상황에 대한 답이나 해결책을 의미합니다. 
문제를 해결하는 것을 "해를 찾다"라고 표현하기도 합니다. 
예를 들어, 수학 문제에서 원하는 값을 구하는 것이 "해"가 되고, 
기술적인 문제에서는 원하는 기능이나 목표를 달성하는 것이 "해"가 될 수 있습니다.

이 문제에서의 "해"는 최대한 많은 균형 잡힌 문자열의 개수를 찾는 것입니다.
주어진 문자열을 분할하여 각 부분 문자열이 
'L'과 'R'의 개수가 같아지는 부분을 찾아 최대한 많은 균형 잡힌 문자열을 찾는 것이
이 문제의 "해"가 됩니다. 
따라서 최종적으로 이 문제에서의 "해"는 정수 값으로 반환되는 최대 균형 잡힌 문자열의 개수입니다.
*/