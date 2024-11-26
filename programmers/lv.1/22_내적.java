
// https://school.programmers.co.kr/learn/courses/30/lessons/70128

class Solution {
    public int solution(int[] a, int[] b) {
        int result = 0;
        
        for(int i=0; i<a.length; i++){
            result += (a[i]*b[i]);
        }
        return result;
    }
}