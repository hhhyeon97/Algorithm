import java.util.*;

/*
https://leetcode.com/problems/neither-minimum-nor-maximum/

2733. Neither Minimum nor Maximum

주어진 배열 nums에서 최소값도 아니고 최대값도 아닌 숫자를 찾는 문제
(만약 그런 숫자가 없다면 -1을 반환)
*/

class Solution {
    public int findNonMinOrMax(int[] nums) {
          // 배열의 길이가 2 이하인 경우 -1 반환
        if(nums.length <=2){
            return -1;
        }
        // 배열의 최소값과 최대값 찾기
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num:nums){
            if(num<min){
                min=num;
            }
            if(num>max){
                max=num;
            }
        }
 // 최소값도 아니고 최대값도 아닌 첫 번째 숫자 찾기
        for (int num: nums){
            if(num != min && num != max){
                return num;
            }
        }
// 그런 숫자가 없을 경우 -1 반환
        return -1;

    }
}

/*
배열 nums의 길이가 2 이하인 경우, 항상 -1을 반환합니다.
왜냐하면 최소값과 최대값을 제외하고 남는 숫자가 없기 때문입니다.
배열의 최소값과 최대값을 찾습니다.
배열을 순회하면서 최소값도 아니고 최대값도 아닌 첫 번째 숫자를 반환합니다.
만약 그런 숫자가 없다면 -1을 반환합니다.
*/



/*

int min, max 설정한 부분 어떤 뜻인지 궁금쓰 

int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;
min 변수를 Integer.MAX_VALUE로 초기화합니다. 
Integer.MAX_VALUE는 자바에서 정수가 가질 수 있는 가장 큰 값입니다.
이렇게 하면 배열을 순회하면서 만나는 모든 숫자가 이 초기값보다 작을 것이므로, 
처음 만나는 숫자가 바로 최소값이 됩니다.
max 변수를 Integer.MIN_VALUE로 초기화합니다. 
Integer.MIN_VALUE는 자바에서 정수가 가질 수 있는 가장 작은 값입니다. 
이렇게 하면 배열을 순회하면서 만나는 모든 숫자가 이 초기값보다 클 것이므로, 
처음 만나는 숫자가 바로 최대값이 됩니다.
*/

/*
배열 순회

for (int num : nums) {
    if (num < min) {
        min = num;
    }
    if (num > max) {
        max = num;
    }
}
for (int num : nums) 구문은 향상된 for문이라고 하며, 
배열 nums의 각 요소를 순회합니다. num은 현재 배열 요소를 나타냅니다.
if (num < min) 구문은 현재 숫자 num이 현재의 최소값 min보다 작은지를 확인합니다. 
작다면, min을 num으로 갱신합니다.
if (num > max) 구문은 현재 숫자 num이 현재의 최대값 max보다 큰지를 확인합니다. 
크다면, max를 num으로 갱신합니다.

배열을 한 번만 순회하기 때문에 시간 복잡도는 O(n)
*/


/*
https://leetcode.com/problems/find-target-indices-after-sorting-array/description/

2089. Find Target Indices After Sorting Array

배열을 정렬하고 target의 인덱스를 찾아서 리스트로 반환하는 문제 
*/

class Solution2 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
         List<Integer> result = new ArrayList<>();
        
         for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result;
    }
}

/*
순서가 중요하고, 중복된 값을 저장해야 할 경우 ArrayList가 적합 !!
*/