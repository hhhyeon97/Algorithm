


/*
https://leetcode.com/problems/shuffle-the-array/description/

1470. Shuffle the Array

주어진 배열을 두 부분으로 나눠서 섞는 문제

ex ) nums = [2, 5, 1, 3, 4, 7]이고 n = 3이라면, 
x 부분은 [2, 5, 1]이고 y 부분은 [3, 4, 7]이 되고 
결과 배열은 [2, 3, 5, 4, 1, 7]이 되어야 한다.
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {
            // 결과를 담을 배열 생성
        int[] result = new int[2 * n];
        
        // x와 y 부분을 번갈아가면서 결과 배열에 추가
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];       // x 부분
            result[2 * i + 1] = nums[n + i]; // y 부분
        }
        
        return result;
    }
}

/*
shuffle 메서드는 nums 배열과 n을 입력으로 받는다.
결과를 담을 배열 result를 생성한다.
반복문을 통해 x와 y 부분을 번갈아가면서 result 배열에 추가한다.
*/



/*
https://leetcode.com/problems/number-of-good-pairs/description/

1512. Number of Good Pairs

배열에서 "좋은 쌍"의 수를 찾는 것

*/


/*
numIdenticalPairs 메서드는 배열을 입력받아 "좋은 쌍"의 수를 반환
count 변수를 0으로 초기화하여 좋은 쌍의 수 세기
첫 번째 for 루프는 배열의 각 원소를 선택한다.
두 번째 for 루프는 선택된 원소 다음에 있는 모든 원소를 비교한다.
nums[i] == nums[j] 조건이 참이면 count를 증가시킨다.
모든 비교가 끝나면 count를 반환한다.
*/

class Solution2 {
    public int numIdenticalPairs(int[] nums) {
          int count = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
/*
예제를 통해 이해하기

예제 1: nums = [1, 2, 3, 1, 1, 3]
우리는 배열에서 "좋은 쌍"의 수를 찾고자 합니다. "좋은 쌍"은 
nums[i]==nums[j]이고 i<j를 만족하는 쌍입니다.

int[] nums = {1, 2, 3, 1, 1, 3};
System.out.println(numIdenticalPairs(nums)); // 예상 출력: 4

단계별 설명

변수 초기화

count를 0으로 초기화합니다.
배열의 길이를 구합니다: length = 6.

첫 번째 for 루프 (i)

i는 0부터 5까지 순회합니다.

두 번째 for 루프 (j)

j는 i + 1부터 5까지 순회합니다.

루프 실행 과정
i = 0
j = 1, nums[0] (1) != nums[1] (2) -> 무시
j = 2, nums[0] (1) != nums[2] (3) -> 무시
j = 3, nums[0] (1) == nums[3] (1) -> count 증가: count = 1
j = 4, nums[0] (1) == nums[4] (1) -> count 증가: count = 2
j = 5, nums[0] (1) != nums[5] (3) -> 무시
i = 1
j = 2, nums[1] (2) != nums[2] (3) -> 무시
j = 3, nums[1] (2) != nums[3] (1) -> 무시
j = 4, nums[1] (2) != nums[4] (1) -> 무시
j = 5, nums[1] (2) != nums[5] (3) -> 무시
i = 2
j = 3, nums[2] (3) != nums[3] (1) -> 무시
j = 4, nums[2] (3) != nums[4] (1) -> 무시
j = 5, nums[2] (3) == nums[5] (3) -> count 증가: count = 3
i = 3
j = 4, nums[3] (1) == nums[4] (1) -> count 증가: count = 4
j = 5, nums[3] (1) != nums[5] (3) -> 무시
i = 4
j = 5, nums[4] (1) != nums[5] (3) -> 무시
i = 5
j = 없으므로 두 번째 for 루프는 실행되지 않음

최종 결과
count는 총 4번 증가했으므로, "좋은 쌍"의 수는 4입니다.

결론
이 예제에서 네 쌍의 좋은 쌍이 있습니다:

(0, 3)
(0, 4)
(3, 4)
(2, 5)
따라서 출력은 4가 됩니다.
*/


