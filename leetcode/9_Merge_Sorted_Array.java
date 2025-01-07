
// https://leetcode.com/problems/merge-sorted-array/description/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // nums1의 마지막 위치
        // ex) m=3, n=3일 때 last = 3+3-1 = 5 (최종 합칠 배열의 요소 개수는 6, 인덱스로는 5)
        int last = m + n - 1;

        // nums1과 nums2의 마지막 요소부터 비교
        int i = m - 1; // nums1의 실제 요소 끝
        int j = n - 1; // nums2의 끝

        // ex )
        // 입력: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // i = 2, j = 2, last = 5

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[last] = nums1[i];
                i--;
            } else {
                nums1[last] = nums2[j];
                j--;
            }
            last--;
        }
        /*
        nums1[i] = 3, nums2[j] = 6 → nums1[last] = 6, j--, last--
        nums1[i] = 3, nums2[j] = 5 → nums1[last] = 5, j--, last--
        nums1[i] = 3, nums2[j] = 2 → nums1[last] = 3, i--, last--
        nums1[i] = 2, nums2[j] = 2 → nums1[last] = 2, j--, last--
        nums1[i] = 1, nums2[j] = - → nums1[last] = 2, i--, last--
        nums1[i] = 1, nums2[j] = - → nums1[last] = 1, i--, last--
        */

        // nums2에 남은 요소가 있으면 nums1 앞부분에 복사
        // ex ) nums1 = [0], m = 0, nums2 = [1], n = 1
        // 결과 : [1]
        while (j >= 0) {
            nums1[last] = nums2[j];
            j--;
            last--;
        }

    }
}