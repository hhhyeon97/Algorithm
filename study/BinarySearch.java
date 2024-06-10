
// 키워드 : 이분탐색

/*
https://leetcode.com/problems/search-insert-position/description/
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end-start) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <target){
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        return start;
    }
}

/*
이 문제는 이분 탐색(Binary Search) 알고리즘을 사용해서 해결할 수 있습니다. 이분 탐색은 정렬된 배열에서 특정 값을 찾거나 위치를 찾는 데 사용되는 효율적인 방법으로, 시간 복잡도가 O(log n)입니다. 이제, 이분 탐색을 이용하여 이 문제를 Java로 해결하는 방법을 단계별로 설명해 드릴게요.

문제 이해하기
입력:
정렬된 배열 nums (중복 없는 정수)
찾고자 하는 target 값
출력:
target이 배열에 있으면 그 인덱스를 반환
target이 배열에 없으면 target이 삽입될 위치의 인덱스를 반환
이분 탐색 개념
이분 탐색은 배열을 반으로 나누어 찾고자 하는 값을 찾는 방법입니다. 
시작점(start), 끝점(end), 그리고 중간점(mid)을 설정하고, 
target과 nums[mid]를 비교하여 탐색 범위를 반으로 줄여 나갑니다.

이분 탐색 과정
start를 배열의 첫 인덱스로, end를 배열의 마지막 인덱스로 설정
반복문을 통해 다음을 수행:
mid를 start와 end의 중간점으로 설정
target이 nums[mid]와 같은지 비교
같으면 mid 반환
target이 더 크면 start를 mid + 1로 이동
target이 더 작으면 end를 mid - 1로 이동
target을 찾지 못하면 start를 반환 (이 위치가 target이 삽입될 위치)

start와 end를 설정하고, 중간 인덱스 mid를 계산합니다.
nums[mid]와 target을 비교하여 start와 end를 조정합니다.
반복문이 끝날 때 target이 삽입될 위치는 start에 저장되어 있습니다.
이렇게 하면 주어진 배열에 대해 효율적으로 target의 위치를 찾거나 삽입할 위치를 찾아낼 수 있습니다. 
이 방법은 시간 복잡도가 O(log n)이므로 매우 효율적입니다.

이분 탐색의 기본 아이디어는 주어진 배열을 반으로 나누는 것입니다. 배열의 중간 인덱스를 구하는 가장 단순한 방법은 (start + end) / 2를 사용하는 것입니다. 하지만 이 방법에는 잠재적인 문제가 있습니다.

문제점: 오버플로우
start와 end가 매우 큰 값일 때, start + end가 정수의 최대 값을 초과하여 오버플로우가 발생할 수 있습니다.
예를 들어, start와 end가 모두 Integer.MAX_VALUE에 가까운 값을 가지면, start + end는 Integer.MAX_VALUE를 넘어설 수 있습니다. 
이는 정수 오버플로우를 일으켜 잘못된 결과를 초래할 수 있습니다.
해결 방법: 안전한 중간값 계산
int mid = start + (end - start) / 2; 이 식은 오버플로우를 방지하기 위해 사용됩니다.
end - start는 두 큰 수의 차이이므로 오버플로우의 위험이 없습니다.
(end - start) / 2는 start와 end의 중간 지점까지의 거리입니다.
따라서, start + (end - start) / 2는 항상 start와 end의 중간 인덱스를 안전하게 계산할 수 있습니다.

예제

int start = 2147483640; // 매우 큰 값
int end = 2147483647; // Integer.MAX_VALUE

// 오버플로우 발생 가능성 있는 식
// int mid = (start + end) / 2; // 오버플로우 발생 가능성 있음

// 안전한 식
int mid = start + (end - start) / 2; // 오버플로우 발생하지 않음
결론
이 식을 사용함으로써 오버플로우 문제를 피하고, 배열의 중간 인덱스를 안전하게 계산할 수 있습니다. 
이는 특히 큰 배열을 다루거나 큰 인덱스 값을 사용할 때 매우 중요합니다. 
*/