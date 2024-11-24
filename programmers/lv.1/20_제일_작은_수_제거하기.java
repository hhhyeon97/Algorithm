
// https://school.programmers.co.kr/learn/courses/30/lessons/12935


class Solution {
    public int[] solution(int[] arr) {
        
     // 배열 크기가 1 이하일 경우 -1을 반환
    if (arr.length <= 1) {
        return new int[]{-1};
    }
    
    // 제일 작은 수 담을 변수 (초기에는 arr 배열 첫번째 원소 값을 담아 둔다.)
    int min = arr[0];
    
    // 첫번째 원소 값인 min 변수와 나머지 arr 배열 원소들을 모두 비교한다.
    // 제일 작은 수를 min에 저장하게 됨 !
    for(int i = 1; i < arr.length; i++) {
        min = Math.min(min, arr[i]);
    }

    // 제일 작은 수를 제외한 모든 arr 배열 값을 저장할 것이므로
    // answer 배열의 길이는 arr 보다 1 작게 설정
    int[] answer = new int[arr.length - 1];

    // answer 배열에 값을 순서대로 채우기 위한 인덱스 역할
    int cnt = 0;
        
    for(int i = 0; i < arr.length; i++) {
        if(min == arr[i]) { // 배열 arr를 순회하며, 최소값(min)과 같지 않은 값만 answer[cnt]에 저장한다.
            continue;
        }
        // 값이 추가될 때마다 cnt++로 인덱스를 증가시킨다.
        answer[cnt++] = arr[i];
    }        
    return answer;
    }
}

/*
정렬의 시간 복잡도는 O(n log n)인데, 
문제에서는 단순히 최소값만 찾으면 됨. 
최소값 탐색은 O(n)으로 해결 가능하므로, 정렬은 불필요하게 느리다.
특히 배열의 크기가 클수록 성능 차이가 커짐.
ㄴ> 작은 배열에서는 정렬 방식도 충분히 가능하다.
그러나 효율성과 원래 배열의 순서 유지가 중요하다면, 
현재 방식처럼 최소값을 찾고 그 값을 제외하는 접근이 더 적합하다.
만약 정렬 방식을 사용하려면 문제 요구사항과 배열 크기에 따라 유연하게 판단하면 된다.
 */