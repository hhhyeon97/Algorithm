
// leetcode 
// 1464. 배열의 두 요소의 최대 곱

class Solution {
    public int maxProduct(int[] nums) {

    // 두 개의 가장 큰 값을 찾기 위해 초기값을 Integer.MIN_VALUE로 설정    
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

  // 배열을 순회하면서 두 개의 가장 큰 값 찾기 
        for (int num : nums) {
            if (num > max1) {
                max2 = max1; // 이전 최대값을 두 번째 최대값으로 이동
                max1 = num; // 새로운 최대값 갱신
            } else if (num > max2) {
                max2 = num; // 두 번째 최대값 갱신
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
