
// https://school.programmers.co.kr/learn/courses/30/lessons/12922

class Solution {
    public String solution(int n) {
        String result = "";

        for(int i=0;i<n;i++) {
           result +=(i%2==0)? "수":"박";
        }

        return result;
    }
}