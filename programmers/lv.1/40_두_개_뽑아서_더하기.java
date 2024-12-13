
// https://school.programmers.co.kr/learn/courses/30/lessons/68644

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        // 중복을 제거하기 위해 Set 사용
        Set<Integer> sumSet = new HashSet<>();
        
        // 모든 두 숫자 쌍을 더함
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]); // 두 숫자의 합을 Set에 추가
            }
        }
        
        // Set을 리스트로 변환한 뒤 정렬
        List<Integer> sortedList = new ArrayList<>(sumSet);
        Collections.sort(sortedList);
        
        // 정렬된 리스트 -> 배열로 변환해서 반환
        return sortedList.stream().mapToInt(i -> i).toArray();
    }
}
/*
HashSet의 역할

1. 중복 제거

HashSet은 동일한 값을 여러 번 넣으려고 해도 하나만 저장된다.
예를 들어, 2를 두 번 넣어도 HashSet에는 한 번만 저장됨.

2. 저장 순서 유지 X

HashSet은 요소의 저장 순서를 보장하지 않음.
HashSet 자체로는 정렬할 수 없음
그래서 정렬하려면 HashSet의 데이터를 다른 자료구조(예: List)로 옮겨야 한다.
*/