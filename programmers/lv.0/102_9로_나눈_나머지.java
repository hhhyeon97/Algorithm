
// https://school.programmers.co.kr/learn/courses/30/lessons/181914

class Solution {
    public int solution(String number) {
        int answer = 0;
        
        int sum = 0;
        
        String[] number_list = number.split("");
        
        for(int i = 0; i<number_list.length; i++){
                 // 문자열 -> 숫자로 변형
            sum+=Integer.parseInt(number_list[i]);
        }
        
        answer = sum%9;
        
        return answer;
    }
}
