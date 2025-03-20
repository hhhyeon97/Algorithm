
// https://school.programmers.co.kr/learn/courses/30/lessons/181844

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        // delete_list를 빠른 탐색이 가능한 HashSet으로 변환
        Set<Integer> deleteSet = new HashSet<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }

        // 삭제할 값이 아닌 원소만 필터링하여 리스트에 저장
        List<Integer> filteredList = new ArrayList<>();
        for (int num : arr) {
            if (!deleteSet.contains(num)) { // delete_list에 없는 값만 추가
                filteredList.add(num);
            }
        }

        // 리스트를 int 배열로 변환하여 반환 (스트림 활용)
        return filteredList.stream().mapToInt(i -> i).toArray();
    }
}
