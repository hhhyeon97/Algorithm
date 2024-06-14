


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