
// https://school.programmers.co.kr/learn/courses/30/lessons/12910

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // 조건을 만족하는 값을 담을 리스트
        List<Integer> list = new ArrayList<>();
        
        // divisor로 나누어 떨어지는 값을 리스트에 추가
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        
        // 리스트가 비어 있다면 -1을 배열로 반환
        if (list.isEmpty()) {
            return new int[] {-1};
        }
        
        // 리스트를 배열로 변환하고 정렬
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}

/*
1. list.stream()
list.stream()은 리스트의 데이터를 스트림(Stream) 형태로 변환하는 메서드

스트림(Stream): 컬렉션(List, Set 등)의 데이터를 처리하기 위한 API. 
데이터를 순차적으로 처리하거나 필터링, 변환 등에 사용.
ex) List<Integer> list = Arrays.asList(1, 2, 3);에서 
list.stream()을 호출하면, 리스트의 각 요소를 순회하면서 처리할 수 있는 스트림이 생성된다.

2. mapToInt(i -> i)
mapToInt: 스트림의 각 요소를 int 타입으로 변환하는 메서드
i -> i: 람다 표현식으로, 리스트의 각 요소 i를 그대로 반환한다는 의미
만약 i * 2로 쓰면, 리스트의 각 요소를 두 배로 변환해서 반환한다는 뜻
위 문제에서는 List<Integer>가 가지고 있는 요소를 
정수 배열로 만들기 위해 그대로 i를 반환하고 있다.

3. .toArray()
.toArray(): 스트림으로 변환된 데이터를 최종적으로 int[] 배열로 변환.
mapToInt를 사용하면 정수형 스트림이 생성되므로, toArray()를 호출하면 정수 배열이 생성된다.

====================================================
: list.stream().mapToInt(i -> i).toArray() 해석 정리

list.stream()으로 List<Integer>를 스트림으로 변환.
mapToInt(i -> i)로 스트림의 각 요소를 정수로 매핑.
.toArray()로 최종 결과를 정수 배열로 변환.

*/