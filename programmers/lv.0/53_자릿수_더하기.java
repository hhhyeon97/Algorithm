
// https://school.programmers.co.kr/learn/courses/30/lessons/120906

class Solution {
    public int solution(int n) {
        
        String s = n+"";
        
        int[] digits = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
                digits[i] = s.charAt(i) - '0';
            
        }
        int sum = 0;
        for(int i=0; i<digits.length; i++){
            sum += digits[i];
        }
        return sum;
    }
}