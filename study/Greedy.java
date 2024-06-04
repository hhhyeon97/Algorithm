

// 키워드: 탐욕법(Greedy)

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
