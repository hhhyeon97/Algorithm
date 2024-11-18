
// https://school.programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        // x의 각 자릿수 합 구하기 위해 문자열로 바꾸기
        String sum = Integer.toString(x);
        
        int num = 0;
        // 각 자릿수 더한 값을 num 변수에 담기
        for(int i = 0; i<sum.length() ; i++){
            num += sum.charAt(i)-48;
        }

        // x와 num을 나누었을 때
        // 나누어 떨어지면 하샤드 수
        // 하샤드 수라면 true / 아니면 false 담아서 반환
        if(x%num==0){
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}