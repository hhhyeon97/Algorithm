
// https://leetcode.com/problems/plus-one/submissions/1500788497/

class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;

        // 끝에서부터 1을 더하면서 Carry(자릿수 올림) 처리
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // 9가 아니라면 올림이 필요 없으므로 바로 반환
            }
            digits[i] = 0; // 9라면 0으로 만들고 다음 자릿수로 넘어감
        }

        // 여기까지 왔다면 가장 앞자리에 1을 추가해야 함 (예 : 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}